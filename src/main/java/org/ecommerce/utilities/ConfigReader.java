package org.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private static final ConfigReader configReader = new ConfigReader();
    private static final String configFilePath = "src//test/resources//config//Config.properties";

    private ConfigReader(){

        properties = new Properties();

        try {

            File file = new File(configFilePath);

            FileInputStream fis = new FileInputStream(file);

            properties.load(fis);

        } catch (Exception e){

            e.printStackTrace();
        }

    }

    public static ConfigReader getInstance(){

        return configReader;
    }

    public String getURL(){

        return properties.getProperty("url");
    }

    public String getBrowserName(){

        return properties.getProperty("browser");
    }

    public int getTimeOut(){

        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public String getFirstName(){

        return properties.getProperty("firstName");
    }

    public String getEmailId(){

        return properties.getProperty("email");
    }

    public String getPassword(){

        return properties.getProperty("password");
    }
}
