package org.selenide.saucedemo.stepdefs;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.selenide.saucedemo.pages.LoginPage;
import org.selenide.saucedemo.pages.ProductsPage;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;


public class SaucedemoPOLoginStepDef extends FunctionalTest {

  LoginPage loginPage;
  ProductsPage productsPage;

  @Given("saucedemo.com page is open")
  public void openSaucedemoPage() {
    open("https://saucedemo.com");
    loginPage = new LoginPage(driver);

    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.headless = false;
    sleep(500);
    loginPage.checksLogoDisplayedPO();
    loginPage.checkCredentialTextVisiblePO();
  }

  @When("enter username {string} in username")
  public void enterUsernamePO(String userName){
    loginPage.enterUserNamePO(userName);
  }

  @When("enter password {string} in password")
  public void enterPasswordPO(String password){
    loginPage.enterPasswordPO(password);
  }

  @When("click on Login")
  public void clickOnLoginPO(){
    productsPage = loginPage.clickOnLoginPO();
  }

  @Then("at least {int} product should be shown in the products page")
  public void atLeastNProductsShouldBeShownInProductsPage(int minProductsCount){
    String title = productsPage.getTitleText();
    assertEquals("PRODUCTS",title);
    productsPage.checkMinimumProductsCount(minProductsCount);
  }
}
