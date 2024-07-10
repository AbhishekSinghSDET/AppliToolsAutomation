package com.applitools.pages;

import com.applitools.tests.BaseTest;
import com.applitools.utils.Pojo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(Pojo objPojo){
        super(objPojo);
    }

    @FindBy(xpath = "//td[@class='text-right bolder nowrap']")
    private List<WebElement> amounts;


    public double getAmount() {
        double total = 0;
        for(WebElement e : amounts){
            String price = e.getText();
            String[] result = price.split(" ");
            if(result[0].equals("+")){
                total = total + Double.parseDouble(result[1].replaceAll(",",""));
            }
            else{
                total = total - Double.parseDouble(result[1].replaceAll(",",""));
            }
        }
        return total;
    }


    public boolean verifyAmount(double num){
        double value = getAmount();
        if(num==value){
            return true;
        }
        return false;
    }
}
