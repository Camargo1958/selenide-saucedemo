Feature: Saucedemo Ecommerce login
  Scenario: user can login in Saucedemo Ecommerce

    Given saucedemo.com page is open
    When  enter username "standard_user" in username
    And   enter password "secret_sauce" in password
    And   click on Login
    Then  at least 1 product should be shown in the products page