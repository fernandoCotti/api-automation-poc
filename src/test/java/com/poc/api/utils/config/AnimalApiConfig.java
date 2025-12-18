package com.poc.api.utils.config;

public class AnimalApiConfig {

    private final String baseUrl;
    private final String endpoint;
    private final String imageField;
    private final boolean arrayResponse;

    public AnimalApiConfig(String baseUrl, String endpoint, String imageField, boolean arrayResponse) {
        this.baseUrl = baseUrl;
        this.endpoint = endpoint;
        this.imageField = imageField;
        this.arrayResponse = arrayResponse;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getImageField() {
        return imageField;
    }

    public boolean isArrayResponse() {
        return arrayResponse;
    }
}
