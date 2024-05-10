@tag
Feature: Purchase te order from E-commerce Website
 Background:
 Given i land on Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on CofirmationPage

    Examples: 
      | name  								      |  password		    |	productName |
      | sampriti.shome009@gmail.com |  Mellon@31      | ZARA COAT 3 | 
    
