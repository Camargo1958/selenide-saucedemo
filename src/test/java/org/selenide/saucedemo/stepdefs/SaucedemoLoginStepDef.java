package org.selenide.saucedemo.stepdefs;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class SaucedemoLoginStepDef {
  @Given("an open browser with saucedemo.com")
  public static void openSaucedemo() {
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;
    open("https://saucedemo.com");
    sleep(500);
    if ($(byClassName("login_logo")).isDisplayed()) {
      $(byClassName("login_credentials")).shouldBe(visible);
    }
  }

  @When("enter username {string} in username field")
  public static void enterUsername(String userName) {
    $(By.id("user-name")).val(userName).pressEnter();
  }

  @When("enter password {string} in password field")
  public static void enterPassword(String password) {
    $(By.id("password")).val(password).pressEnter();
  }

  @When("click on Login button")
  public static void clickOnLogin() {
    $(By.id("login-button")).click();
  }

  @Then("the products page should be shown with at least {int} product")
  public void productsPageShouldBeShownWith(int resultsCount) {
    //Title validation
    $(By.className("title")).shouldHave(text("Products"));
    //Inventory container validation
    $$(By.className("inventory_list")).shouldHave(sizeGreaterThanOrEqual(resultsCount));
  }
}
