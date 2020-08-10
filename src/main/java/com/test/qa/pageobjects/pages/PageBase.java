package com.test.qa.pageobjects.pages;

import org.openqa.selenium.WebDriver;

public class PageBase {
    protected WebDriver driver;

    PageBase(WebDriver driver) {
        this.driver = driver;
    }
}
