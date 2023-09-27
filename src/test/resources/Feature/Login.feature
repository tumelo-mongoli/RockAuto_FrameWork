
@tag
Feature: Login
  I want to use this template for my feature file

  @tag1
  Scenario: Successful Login with Valid Credentials
    Given User Launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admi"
    And Click on Login
    Then There should be a Log out link  
    Then Page Title should be "Your store. Login"
    And close browser


