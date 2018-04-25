#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@ApplicationLogin
Feature: Login into Application
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Background: User navigates to Company home page
    Given I am on the "Company home" page on URL "http://the-internet.herokuapp.com/login"
    Then I should see "Log In as Employee" message

  Scenario: Successful login
    When I fill in "Username" with "tomsmith"
    And I fill in "Password" with "SuperSecretPassword!"
    And I click on the "Log In" button
    Then I am on the "My profile" page on URL "www.mycompany.com/myprofile"
    And I should see "Welcome to your profile" message
    And I should see the "Log out" button

  Scenario Outline: Failed login using wrong credentials
    When I fill in "Username" with "<username>"
    And I fill in "Password" with "<password>"
    And I click on the "Login" button
    And I should see "<warning>" message
    Examples:
      | username    | password   | warning                           |
      | Test        | !23        | Incorrect credentials. Try again! |