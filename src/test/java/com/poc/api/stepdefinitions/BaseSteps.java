package com.poc.api.stepdefinitions;

import com.poc.api.utils.context.TestContext;

public abstract class BaseSteps {

    protected final TestContext testContext;

    protected BaseSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    protected void attachResponse(String title) {
        if (testContext.getResponse() != null && testContext.getScenario() != null) {
            testContext.getScenario().attach(
                testContext.getResponse().asPrettyString(),
                "application/json",
                title
            );
        }
    }
}
