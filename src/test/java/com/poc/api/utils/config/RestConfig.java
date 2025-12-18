package com.poc.api.utils.config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestConfig {

    public static RequestSpecification defaultRequest() {
        return RestAssured
                .given()
                .header("Accept", "application/json");
    }
}
