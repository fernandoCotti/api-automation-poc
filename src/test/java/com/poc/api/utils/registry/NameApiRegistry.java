package com.poc.api.utils.registry;

import java.util.HashMap;
import java.util.Map;

import com.poc.api.utils.config.NameApiConfig;

public class NameApiRegistry {  //Registry of the name APIs

    private static final Map<String, NameApiConfig> APIS = new HashMap<>();

    static {
        APIS.put("gender", new NameApiConfig(
                "https://api.genderize.io",
                "/",
                "gender",
                false
        ));

        APIS.put("nationality", new NameApiConfig(
                "https://api.nationalize.io",
                "/",
                "country",
                true
        ));
    }

    public static NameApiConfig get(String type) {
        return APIS.get(type.toLowerCase());
    }
}
