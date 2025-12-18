package com.poc.api.utils.registry;

import java.util.Map;

import com.poc.api.utils.config.AnimalApiConfig;

public class AnimalApiRegistry {  //Registry of the animal APIs

    public static final Map<String, AnimalApiConfig> ANIMAL_APIS = Map.of(
            "dog", new AnimalApiConfig(
                    "https://random.dog",
                    "/woof.json",
                    "url",
                    false
            ),
            "cat", new AnimalApiConfig(
                    "https://api.thecatapi.com",
                    "/v1/images/search",
                    "url",
                    true
            )
    );

    private AnimalApiRegistry() {
    }
}
