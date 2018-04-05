Feature: Login

  Scenario: Registration Flow Validation via App
  As a user I should be able to see my google account
  when I try to register myself in Quikr

    When I launch Quikr app
    And I choose to log in using Google
    Then I see account picker screen with my email address "testemail@gmail.com"

  Scenario: Registration Flow Validation via web
  As a User I want to verify that
  I get the option of choosing Facebook when I choose to register

    When I launch Quikr mobile web
    And I choose to register
    Then I should see an option to register using Facebook
