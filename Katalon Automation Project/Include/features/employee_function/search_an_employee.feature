Feature: Search for an employee in Employee List

  Scenario: Search for the existing employee
    Given I am on the "Employee List" page
    When I search for "John Doe" in the "Employee List" field
    Then I should see "John Doe" in search results with correct details
