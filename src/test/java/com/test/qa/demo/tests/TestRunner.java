package com.test.qa.demo.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"/src/main/java/com/test/qa/pageobjects/stepdefinition"},
        plugin = {"html:target/cucumber-reports"},
        monochrome = true,
        tags = {"@Login"},
        strict = true
)
@RunWith(Cucumber.class)
public class TestRunner {

}
