package com.poc.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import com.poc.api.utils.registry.NameApiRegistry;
import com.poc.api.utils.config.NameApiConfig;
import com.poc.api.utils.context.TestContext;

public class NamePredictionSteps extends BaseSteps{
    
    private NameApiConfig apiConfig;

    public NamePredictionSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("the {string} prediction API is available")
    public void the_prediction_api_is_available(String apiType) {
        apiConfig = NameApiRegistry.get(apiType);
        Assert.assertNotNull("API configuration not found for type: " + apiType, apiConfig);

        RestAssured.baseURI = apiConfig.getBaseUrl();
    }

    @When("I request a prediction for name {string}")
    public void i_request_a_prediction_for_name(String name) {
        testContext.setResponse(
            RestAssured
                    .given()
                        .queryParam("name", name)
                        .header("Accept", "application/json")
                    .when()
                        .get(apiConfig.getEndpoint())
        );
        
        attachResponse("Names predictions response"); //To see JSON response in the report
    }

    @Then("the response status code must be {int}")
    public void the_response_status_code_must_be(Integer statusCode) {
        testContext.getResponse().then().statusCode(statusCode);
    }

    @Then("the response should contain the name {string}")
    public void the_response_should_contain_the_name(String expectedName) {
        Assert.assertEquals(
                expectedName,
                testContext.getResponse().jsonPath().getString("name")
        );
    }

    @Then("the response should contain prediction data")
    public void the_response_should_contain_prediction_data() {

        if (apiConfig.isArrayResponse()) {
            Assert.assertFalse(
                    "Prediction array is empty",
                    testContext.getResponse().jsonPath().getList(apiConfig.getMainField()).isEmpty()
            );
        } else {
            Assert.assertNotNull(
                    "Prediction field is null",
                    testContext.getResponse().jsonPath().get(apiConfig.getMainField())
            );
        }
    }
}
