Feature: Home page functionality

Background: User is logged in
  Given user is logged in with "standard_user" and "secret_sauce"
  And user is on the home page
  When user selects product
  
@addtocart
Scenario: Add product to cart
  When clicks on Add to cart
  Then product "Sauce Labs Backpack" should be added to cart
  
@removecart
Scenario: Remove item from cart
  When user clicks on Remove from cart
  Then "Sauce Labs Backpack" should be removed from cart