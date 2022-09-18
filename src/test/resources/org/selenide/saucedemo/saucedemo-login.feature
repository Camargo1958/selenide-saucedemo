Feature: Saucedemo Shop login
  Scenario: user can login in Saucedemo Shop

    Given an open browser with saucedemo.com
    When enter username "standard_user" in username field
    And   enter password "secret_sauce" in password field
    And   click on Login button
    Then  the products page should be shown with at least 1 product