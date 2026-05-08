Feature: Navigation Test


  Scenario: I can navigate to a url
    Given I navigate to "https://the-internet.herokuapp.com"
    When I click on ADD_REMOVE_ELEMENTS
    And I click on ADD_ELEMENT
    Then I should see DELETE is visible
    And I click on DELETE
    Then I shouldn't see DELETE is visible