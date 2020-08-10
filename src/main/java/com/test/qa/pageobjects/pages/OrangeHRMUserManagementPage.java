package com.test.qa.pageobjects.pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMUserManagementPage extends PageBase {

    private static Logger logger = LogManager.getLogger(OrangeHRMUserManagementPage.class);
    private By lblHeader = By.xpath("//h1");

    public OrangeHRMUserManagementPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
}
