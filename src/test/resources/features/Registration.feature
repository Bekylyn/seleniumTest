Feature: User Registration
  Scenario: Valid Registration
Given  User is on the registration page
When  User enters valid registration details
And  User clicks the Register button
Then User should be redirected to the products page