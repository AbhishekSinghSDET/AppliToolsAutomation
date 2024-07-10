package com.applitools.tests;

import com.applitools.utils.ConfigReader;
import com.applitools.utils.Pojo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest extends Pojo {

    @BeforeClass
    public void setup(){
        this.loadConfiguration();
        this.initializeEnv();
    }

    private void loadConfiguration() {
        try {
            this.setProperties(new Properties());
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            this.getProperties().load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @AfterClass
    public void quit(){
        this.getDriver().quit();
    }


    public void initializeEnv(){
        ConfigReader configReader = new ConfigReader();
        this.setDriver(getBrowserSpecificDriver(configReader.getData("browser")));
        this.getDriver().get(configReader.getData("baseURL"));
        this.getDriver().manage().window().maximize();

    }

    public WebDriver getBrowserSpecificDriver(String browser){
        if(browser==null){
            return null;
        }
        switch(browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                ChromeDriver driver = new ChromeDriver(options);
                return driver;

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                return null;
        }
    }



}
