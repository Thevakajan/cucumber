package com.test.qa.pageobjects.pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    private static Logger logger = LogManager.getLogger(LoginPage.class);
    private By hdrLogin = By.xpath("//h2");
    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnSubmit = By.className("radius");
    private By alertLogoutSuccess = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void login(String username, String password) {
        driver.findElement(txtUserName).sendKeys(username);
        logger.log(Level.INFO, "Entered username : " + username);
        driver.findElement(txtPassword).sendKeys(password);
        logger.log(Level.INFO, "Entered password : " + password);
        driver.findElement(btnSubmit).click();
        logger.log(Level.INFO, " Clicked login button");
    }
    public boolean isLoginPageDisplayed() {
        return driver.findElement(hdrLogin).isDisplayed();
    }
    public boolean isLogoutAlertDisplayed() {
        return driver.findElement(alertLogoutSuccess).isDisplayed();
    }
    public String getLogoutAlertMessage() {
        return driver.findElement(alertLogoutSuccess).getText();
    }
    public String getErrorMessage() {
        String strMessage;
        try {
            strMessage = driver.findElement(alertLogoutSuccess).getText();
        } catch (Exception e) {
            strMessage = "";
            logger.log(Level.ERROR, " Error in reading message");
        }
        return strMessage;
    }

}
