package org.selenide.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class LoginPage extends PageObject{

    public LoginPage(WebDriver driver)
        {
            super(driver);
            assertTrue(logo.isDisplayed());
        }

    private WebElement logo = $(byClassName("login_logo"));
    
    private WebElement credentialsText = $(byClassName("login_credentials"));

    private WebElement userName = $(By.id("user-name"));

    private WebElement password = $(By.id("password"));

    private WebElement loginButton = $(By.id("login-button"));
    
    public boolean checksLogoDisplayedPO() {
        return this.logo.isDisplayed();
    }

    public boolean checkCredentialTextVisiblePO() {
        return this.credentialsText.isDisplayed();
    }

    public void enterUserNamePO(String name) {
        //userName.val(name).pressEnter();
        this.userName.sendKeys(name);
    }

    public void enterPasswordPO(String password) {
        this.password.sendKeys(password);
    }

    public ProductsPage clickOnLoginPO() {
        this.loginButton.click();
        return new ProductsPage(driver);
    }

}
