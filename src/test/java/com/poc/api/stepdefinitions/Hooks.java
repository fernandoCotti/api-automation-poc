package com.poc.api.stepdefinitions;

import com.poc.api.utils.context.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before(Scenario scenario) {
        testContext.setScenario(scenario);
    }
}


