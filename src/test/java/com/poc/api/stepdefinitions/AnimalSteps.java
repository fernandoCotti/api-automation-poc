package com.poc.api.stepdefinitions;

import com.poc.api.utils.registry.AnimalApiRegistry;
import com.poc.api.utils.config.AnimalApiConfig;
import com.poc.api.utils.context.TestContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnimalSteps extends BaseSteps{

    private AnimalApiConfig apiConfig;

    public AnimalSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("the animal API {string} is available")
    public void the_animal_api_is_available(String animal) {

        apiConfig = AnimalApiRegistry.ANIMAL_APIS.get(animal.toLowerCase());
        if (apiConfig == null) {
            throw new IllegalArgumentException("Unsupported animal: " + animal);
        }
        // Qué API uso
        RestAssured.baseURI = apiConfig.getBaseUrl();
    }

    @When("I request a random animal image")
    public void i_request_a_random_animal_image() {

        testContext.setResponse(
            RestAssured
                    .given()
                        .header("Accept", "application/json")
                    .when()
                        .get(apiConfig.getEndpoint())
        );
        
        attachResponse("Names predictions response"); //To see JSON response in the report
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        testContext.getResponse()
                .then()
                .statusCode(statusCode);
    }

    @And("the response contains a valid image url")
    public void the_response_contains_a_valid_image_url() {

        String imageUrl;

        if (apiConfig.isArrayResponse()) {
            imageUrl = testContext.getResponse().jsonPath().getString("[0]." + apiConfig.getImageField());
        } else {
            imageUrl = testContext.getResponse().jsonPath().getString(apiConfig.getImageField());
        }

        assertNotNull("Image URL should not be null", imageUrl);
        assertTrue("Image URL should be an http URL", imageUrl.startsWith("http"));
    }
}
