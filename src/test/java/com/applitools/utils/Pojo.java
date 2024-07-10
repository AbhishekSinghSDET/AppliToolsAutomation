package com.applitools.utils;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Pojo {

    private WebDriver driver;

    private Properties properties;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
