package com.poc.api.utils.context;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;

public class TestContext {

    private Response response;
    private Scenario scenario;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
