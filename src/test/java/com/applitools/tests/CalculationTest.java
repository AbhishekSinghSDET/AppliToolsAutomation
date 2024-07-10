package com.applitools.tests;

import com.applitools.pages.HomePage;
import com.applitools.pages.LoginPage;
import com.applitools.utils.ExcelDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculationTest extends BaseTest{
    LoginPage loginPage = null;
    HomePage homePage = null;


    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
    public void calculate(String username, String password){
        loginPage = new LoginPage(this);
        loginPage.login(username, password);
        homePage = new HomePage(this);
        double price = homePage.getAmount();
        Assert.assertEquals(price,1996.22);
    }

}