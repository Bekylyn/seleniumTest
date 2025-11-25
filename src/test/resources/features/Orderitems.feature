Feature: Order and Remove Items
  Background:Login
    Given browser is open for order item test
    And the user enters the username
    And the user enters the password
    And the user clicks the login button

  Scenario: User orders and removes items from the cart

    Then the user should see all products
    And the user clicks to filter product from low to high
    And the user add item bike light
    And the user add item fleece jacket
    And the user clicks shopping cart
    And the user removes fleece jacket item
    And the user clicks on the menu bar
    And the user selects all items
    And the user clicks on the shopping cart icon
    And the user clicks on checkout
    Then the user should see the check out form
    And the  user enters first Name
    And the user enters Last Name
    And the user enters Postal Code
    And the user clicks continue
    And the user verifies the tax is 0.80
    And the user clicks finish

