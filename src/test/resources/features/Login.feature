Feature: Login feature

  Scenario: Successful Login

    Given I am in the Koel login page
    And I enter my email "jose@test.com"
    And I enter my password "te$t$tudent"
    When I click submit
    Then I should be logged in
