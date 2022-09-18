package org.selenide.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage extends PageObject{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement pageTitle =  $(By.className("title"));

    public String getTitleText(){
        return this.pageTitle.getText();
    }

    public void checkMinimumProductsCount(int minimumCount){
        $$(By.className("inventory_list")).shouldHave(sizeGreaterThanOrEqual(1));
    }

    public void clicksOnFirstProductPicture() {
        $$(By.className("inventory_list")).first().find(By.className("inventory_item_img")).click();
    }
}
