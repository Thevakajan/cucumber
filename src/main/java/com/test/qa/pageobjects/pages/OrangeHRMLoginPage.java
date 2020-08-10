package com.test.qa.pageobjects.pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrangeHRMLoginPage extends PageBase {

    private static Logger logger = LogManager.getLogger(OrangeHRMLoginPage.class);
    private By txtUsername = By.id("txtUsername");
    private By txtPassword = By.id("txtPassword");
    private By btnLogin = By.id("btnLogin");
    private By spanMessage = By.id("spanMessage");

    public OrangeHRMLoginPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    public OrangeHRMDashboardPage login(String username, String password) {
        driver.findElement(txtUsername).sendKeys(username);
        logger.log(Level.INFO, "Entered username : " + username);
        driver.findElement(txtPassword).sendKeys(password);
        logger.log(Level.INFO, "Entered password : " + password);
        driver.findElement(btnLogin).click();
        logger.log(Level.INFO, " Clicked login button");
        return new OrangeHRMDashboardPage(driver);
    }

    public String getErrorMessage() {
        String strMessage;
        try {
            strMessage = driver.findElement(spanMessage).getText();
        } catch (Exception e) {
            strMessage = "";
            logger.log(Level.ERROR, " Error in reading message");
        }
        return strMessage;
    }
}
