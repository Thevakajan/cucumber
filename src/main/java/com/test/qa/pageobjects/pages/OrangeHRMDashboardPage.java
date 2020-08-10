package com.test.qa.pageobjects.pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMDashboardPage extends PageBase {

    private static Logger logger = LogManager.getLogger(OrangeHRMDashboardPage.class);
    private By lblHeader = By.xpath("//h1");
    private By lnkAdminMenu = By.id("menu_admin_viewAdminModule");
    private By divWelcomeMenu = By.id("welcome");
    private By lnkLogout = By.linkText("Logout");

    public OrangeHRMDashboardPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    public boolean isDashboardDisplayed() {
        boolean flag = false;
        try {
            logger.log(Level.INFO, "Checking if dashboard displayed");
            driver.findElement(lblHeader).isDisplayed();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
