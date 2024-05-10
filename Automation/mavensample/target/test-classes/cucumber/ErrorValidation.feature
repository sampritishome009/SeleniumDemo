@tag
Feature: Title of your feature
  I want to use this template for my feature file
  
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given i land on Ecommerce page 
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is dispalyed

     Examples: 
      | name  								            |  password		      |	
      | rahulshdssetty.shome009@gmail.com |  Mellon@3102      |  
