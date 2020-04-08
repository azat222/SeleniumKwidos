Feature: Login features

  @Smoke @StageOnly
  Scenario Outline: Login Empty Email
    Given I open login page
    When I add <email> email to the emial field
    And I add <password> password to the password field
    And I click login button
    Then I see login successfull message

    Examples:
      |email                  | password        |
      |""                     | "Qwerty1"       |


  @Regression
  Scenario: Login Empty Password
    Given I open login page
    When I add "azat@testpro.io" email to the emial field
    And I add "" password to the password field
    And I click login button
    Then I see login successfull message


  @Regression
  Scenario: Login Empty Email
    Given I open login page
    When I add "azat@testpro.io" email to the emial field
    And I add "" password to the password field
    And I click login button
    Then I see login successfull message