package org.selenide.saucedemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber/cucumber-html-report.html",
        "junit:target/cucumber/cucumber-junit-report.xml",
        "json:target/cucumber/cucumber.json"})
public class SaucedemoTest {
}
