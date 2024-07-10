package com.applitools.pages;

import com.applitools.utils.Pojo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(Pojo objPojo){
        super(objPojo);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "log-in")
    private WebElement loginButton;

    public void login(String username, String password) {
//        usernameInput.sendKeys(this.getObjPojo().getProperties().getProperty("username"));
//        passwordInput.sendKeys(this.getObjPojo().getProperties().getProperty("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
