package com.vonzhou.example.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 2018/4/18.
 */
public class YamlConfig {
    private static final Map<String, String> RESOURCE_LOCATIONS = new HashMap<>();

    static {
        RESOURCE_LOCATIONS.put("app", "classpath:app.yml");
        RESOURCE_LOCATIONS.put("db", "classpath:db.yml");
        RESOURCE_LOCATIONS.put("workspace-config", "classpath:workspace-config.yml");
    }

    public static Map<String, String> getYamlResources() {
        return RESOURCE_LOCATIONS;
    }
}
