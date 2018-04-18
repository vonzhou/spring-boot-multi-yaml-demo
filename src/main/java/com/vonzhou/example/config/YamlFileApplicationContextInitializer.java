package com.vonzhou.example.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 2018/4/18.
 */
public class YamlFileApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        YamlConfig.getYamlResources()
                        .forEach((key, value) -> addYamlPropertiesToSpringEnvironment(applicationContext, key, value));
    }

    private void addYamlPropertiesToSpringEnvironment(ConfigurableApplicationContext applicationContext, String resourceName,
                    String resourceLocation) {
        try {
            Resource resource = applicationContext.getResource(resourceLocation);
            YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
            PropertySource<?> yamlProperties = yamlPropertySourceLoader
                            .load(resourceName, resource, applicationContext.getEnvironment().getActiveProfiles()[0]);
            applicationContext.getEnvironment().getPropertySources().addLast(yamlProperties);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load resource file", e);
        }
    }
}
