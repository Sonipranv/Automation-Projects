Feature: Validate login functionality

  @tag1
  Scenario: Login with valid credentials
    Given I navigate to login page
    When I enter valid credentials username & password and click login
    Then I shoud see Dashboard or a "Welcome" messege
   
  Scenario: Login with invalid credentials
    Given I navigate to login page
    When I enter invalid credentials username & password and click login
    Then I should see an error saying "Invalid credentials"
