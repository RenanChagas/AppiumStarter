Feature: Catalog

  Background:
    When I access the UICatalogApp

  Scenario: Test the alert function

    When I click the alert button
    And I click the text entry button
    And I type the text "Hello"
    Then I click the ok button

  Scenario: Test the scroll function and index elements

    When I scroll down
    And I click the Steppers button
    And I increment an value on index 0
    And I increment an value on index 0
    And I increment an value on index 1
    Then I check the text on index 0
    And i check the text on index 1

  Scenario: Test the picker function

    When I click the Picker View button
    And I type a number "220" on index 0
    And I type a number "55" on index 1