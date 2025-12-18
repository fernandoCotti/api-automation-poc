package com.poc.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;

import com.poc.api.models.creatingUser.CreateUserRequest;
import com.poc.api.models.creatingUser.CreateUserResponse;
import com.poc.api.utils.context.TestContext;

public class UserManagementSteps extends BaseSteps{

    public UserManagementSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("the user management API is available")
    public void the_user_management_api_is_available() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("I create a user with name {string} and job {string}")
    public void i_create_a_user_with_name_and_job(String name, String job) {

        CreateUserRequest request = new CreateUserRequest(name, job);

        testContext.setResponse(
            RestAssured
                    .given()
                        .header("Content-Type", "application/json")
                        .body(request)
                    .when()
                        .post("/users")
        );

        attachResponse("User created as follows:");
    }

    @Then("the response should contain a user id")
    public void the_response_should_contain_a_user_id() {
        String id = testContext.getResponse().jsonPath().getString("id");
        Assert.assertNotNull("User ID should not be null", id);
    }


    @When("I update user with id {string} using name {string} and job {string}")
    public void i_update_user_with_id_using_name_and_job(String id, String name, String job) {

        CreateUserRequest request = new CreateUserRequest(name, job);

        testContext.setResponse(
            RestAssured
                    .given()
                        .header("Content-Type", "application/json")
                        .body(request)
                    .when()
                        .put("/users/" + id)
        );
                    
        attachResponse("Updated user as follows:");
    }

    @When("I delete the user with id {int}")
    public void i_delete_the_user_with_id(Integer userId) {

        testContext.setResponse(
                RestAssured
                        .given()
                        .when()
                        .delete("/users/" + userId)
        );

        attachResponse("Se eliminó el usuario:");
    }
}
