package com.applitools.pages;

import com.applitools.utils.Pojo;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private Pojo objPojo;

    public BasePage(Pojo objPojo){
        this.objPojo = objPojo;
        PageFactory.initElements(this.getObjPojo().getDriver(), this);
    }

    public Pojo getObjPojo() {
        return objPojo;
    }

    public void setObjPojo(Pojo objPojo) {
        this.objPojo = objPojo;
    }
}
