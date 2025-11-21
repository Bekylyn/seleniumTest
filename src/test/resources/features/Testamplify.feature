
Feature: TestAmplify Landing Page


  Scenario: Open landing page and click Start here button
    Given User is on the landing page
    When user sees the start here button
    When user clicks on see how it works button
    Then video pop up should appear

