Feature: Saucedemo products

  Background: user can login in Saucedemo Ecommerce

  Scenario: user can view a product in Saucedemo Ecommerce

    Given the user were on products page
    When clicks the first product picture
    Then  the products detail page should be shown with description and $"29.99" price