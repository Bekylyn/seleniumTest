
Feature: Buy the Backpack

  Scenario: User buys a backpack and completes the order
    Given browser is open for backpack test
    When user is on the page
    And user enters the username
    And user enters the password
    And user clicks the login button
    Then user should see all products
    And user selects item backpack
    And user clicks shopping cart
    Then user clicks on checkout
    And user enters First Name
    And user enters Last Name
    And user enters Postal Code
    And user clicks continue
    And user clicks finish

