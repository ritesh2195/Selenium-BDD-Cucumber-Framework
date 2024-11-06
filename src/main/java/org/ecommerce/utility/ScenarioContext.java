package org.ecommerce.utility;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static Scenario scenario;
    private static Map<String, Object> contextData = new HashMap<>();

    public static void setContext(Scenario scenario) {

        ScenarioContext.scenario = scenario;
    }

    public static Scenario getScenario() {

        return scenario;
    }

    public static void setData(String key, Object value) {

        contextData.put(key, value);
    }

    public static Object getData(String key) {

        return contextData.get(key);
    }
}
