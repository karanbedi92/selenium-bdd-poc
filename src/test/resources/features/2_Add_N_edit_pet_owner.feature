
@PetClinic
Feature: Add N Edit Pet owner Application
  As Admin,
  I want to Edit Owner
  In order to add Pets

  Background: User navigates to Petclinic Home page
    Given I am on the home page with  URL "http://localhost:8080/petclinic/"
    Then I should see Home Page


 Scenario: Add Second  Owner
    When I Navigate to  Add Owner
    And I fill in First Name "Gaurav"
    And I fill in Last Name "Kumar"
     And I fill in Address "abc"
     And I fill in City "Pune"
    And I fill in Telephone "8898657452"
    And I click on Add Owner
    Then I should see owner information added with Telephone "8898657452"
  
  
  Scenario: Edit First Owner
    When I Navigate to  Search Owner
      And I fill in Last Name "Tidke"
       And I click on Find Owner
        And I click  on name "Ganesh Tidke"
        And click on Edit Owner
            And I fill in First Name "Ganesh"
     And I fill in Address "E-303,Horizon"
     And I fill in City "Pune"
    And I fill in Telephone "9764399285"
    And I click on Add Owner
    Then I should see owner information added with Telephone "9764399285"


  