package org.selenide.saucedemo.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.selenide.saucedemo.stepdefs.SaucedemoLoginStepDef;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SaucedemoProductsStepDef {

    @Given("the user were on products page")
    public void the_user_were_on_products_page() {
        SaucedemoLoginStepDef.openSaucedemo();
        SaucedemoLoginStepDef.enterUsername("standard_user");
        SaucedemoLoginStepDef.enterPassword("secret_sauce");
        SaucedemoLoginStepDef.clickOnLogin();
        //Title validation
        $(By.className("title")).shouldHave(text("Products"));
        //Inventory container validation
        $$(By.className("inventory_list")).shouldHave(sizeGreaterThanOrEqual(1));
    }
    @When("clicks the first product picture")
    public void clicks_the_first_product_picture() {
        $$(By.className("inventory_list")).first().find(By.className("inventory_item_img")).click();
    }
    @Then("the products detail page should be shown with description and ${string} price")
    public void the_products_detail_page_should_be_shown_with_description_and_price(String price) {
        $(By.className("inventory_details_price")).shouldHave(text(price));
        String pngFileName = screenshot("product_detail");
        sleep(2000);
    }
}
