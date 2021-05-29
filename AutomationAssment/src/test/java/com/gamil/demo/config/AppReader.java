package com.gamil.demo.config;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppReader {

    static Properties configProps;

    public static void loadAppConfig() {
        configProps = loadConfigProperties("appConfig.properties");
    }
    public static String getPropertyValue(String propsKey){
        if(configProps == null){
            loadAppConfig();
        }
        return configProps.getProperty(propsKey);
    }
    public static Properties loadConfigProperties(String filename) {
        String configLocation = System.getProperty("user.dir") + File.separator + "propertyConfig";
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(configLocation + File.separator + filename));
        } catch (IOException exp) {
            Assert.fail("File: " + filename + " Not present in location :" + configLocation);
        }
        return pro;
    }
}
