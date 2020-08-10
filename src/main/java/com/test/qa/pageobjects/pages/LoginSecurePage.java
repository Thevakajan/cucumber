package com.test.qa.pageobjects.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSecurePage extends PageBase {

    private Logger logger = LogManager.getLogger(LoginSecurePage.class);
    private By hdrSecureArea = By.xpath("//h2");
    private By btnLogout = By.xpath("//a[@href='/logout']");
    private By alertLoginSuccess = By.id("flash");

    public LoginSecurePage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    public boolean isLoginSecurePageDisplayed() {
        return driver.findElement(hdrSecureArea).isDisplayed();
    }
    public  void clickLogout() {
        driver.findElement(btnLogout).click();
    }
    public boolean isLoginAlertDisplayed() {
        return driver.findElement(alertLoginSuccess).isDisplayed();
    }
    public String getLoginAlertMessage() {
        return driver.findElement(alertLoginSuccess).getText();
    }
}
