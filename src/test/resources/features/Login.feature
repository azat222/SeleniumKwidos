Feature: Login features

  Background:
   Given I open login page

  Scenario: Login Success
    Given I add "azat@testpro.io" email to the emial field
    And I add "Qwerty1" password to the password field
    And I clcik login button
    Then I see login successfull message

  Scenario: Login Empty Email
    Given I add "" email to the emial field
    And I add "Qwerty1" password to the password field
    And I clcik login button
    Then I see login successfull message

  Scenario: Login Empty Password
    Given I add "azat@testpro.io" email to the emial field
    And I add "" password to the password field
    And I clcik login button
    Then I see login successfull message


