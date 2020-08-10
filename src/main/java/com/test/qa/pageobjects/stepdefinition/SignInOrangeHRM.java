package com.test.qa.pageobjects.stepdefinition;

import com.test.qa.pageobjects.pages.OrangeHRMDashboardPage;
import com.test.qa.pageobjects.pages.OrangeHRMLoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SignInOrangeHRM {
    public static Properties prop = new Properties();
    protected static WebDriver driver;
    private static String os;
    private static String browser;
    private static String baseUrl;
    private static String webDriverLocation;
 @Before
    public void setup() throws IOException {
        InputStream input = null;
        input =
                this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
        prop.load(input);
        os = prop.getProperty("os");
        browser = prop.getProperty("browser");
        baseUrl = prop.getProperty("orangeHRMBaseUrl");
        webDriverLocation = prop.getProperty("webDriverLocation");
        switch (os) {
            case "windows":
                if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", webDriverLocation +
                            "chromedriver.exe");
                    driver = new ChromeDriver();
                } else {
                    System.setProperty("webdriver.gecko.driver", webDriverLocation +
                            "geckodriver,exe");
                    driver = new FirefoxDriver();
                }
                break;
            case "ubuntu":
                if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", webDriverLocation +
                            "chromedriver");
                    driver = new ChromeDriver();
                } else {
                    System.setProperty("webdriver.gecko.driver", webDriverLocation +
                            "geckodriver");
                    driver = new FirefoxDriver();
                }
                break;
        }
    }
 @After
    public void tearDown(Scenario scenario) {
        try {
            scenario.write("Current Page URL is " + driver.getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        driver.quit();
    }
    @Given("^I launch OrangeHRM application$")
    public void i_launch_OrangeHRM_application() {
        driver.get(baseUrl);
    }
    @When("^I sign in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_sign_in_with_username_and_password(String username, String password) {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
        loginPage.login(username, password);
    }
    @Then("^I should see dashbord page$")
    public void i_should_see_dashbord_page() {
        OrangeHRMDashboardPage dashboardPage = new OrangeHRMDashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }
    @Then("^I should get error message \"([^\"]*)\"$")
    public void i_should_get_error_message(String errMessage) {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
        Assert.assertEquals("Error message does not match", errMessage,
                loginPage.getErrorMessage());
    }

}

