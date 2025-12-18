package com.poc.api.utils.config;
public class NameApiConfig {

    private final String baseUrl;
    private final String endpoint;
    private final String mainField;
    private final boolean arrayResponse;

    public NameApiConfig(String baseUrl, String endpoint, String mainField, boolean arrayResponse) {
        this.baseUrl = baseUrl;
        this.endpoint = endpoint;
        this.mainField = mainField;
        this.arrayResponse = arrayResponse;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getMainField() {
        return mainField;
    }

    public boolean isArrayResponse() {
        return arrayResponse;
    }
}
