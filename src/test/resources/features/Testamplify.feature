
Feature: TestAmplify Landing Page


  Scenario: Open landing page and click Start here button
    Given User is on the landing page
    When user click on get started
    Then User should be redirected to the registration page
    And user enters first name "Tomisin"
    And user enters last name "Akin"
    And User selects country and enters contact number "8023456789"
    And user enters email address "shol@yopmail.com"
    And user enters password "Testamplify@55"
    And user confirms password "Testamplify@55"
    And user clicks on signup
    Then user should be able to verify email
    And user should enter otp




