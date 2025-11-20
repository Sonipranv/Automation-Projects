Feature: Add a new employee in the system

  Scenario: Add a employee with valid details and profile picture
    Given I am logged into Orangehrm System
    When I navigate to "PIM" module and click on "add an employe"
    And I fill required fields First Name: "John" , Last Name: "Doe" and upload a profile picture
    Then I should see the employee is added successfully in the system
