package org.selenide.saucedemo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage {

    public void checkProductDetailsPrice(String price) {
        $(By.className("inventory_details_price")).shouldHave(text(price));
    }
}
