
@PetClinic
Feature: Add pet
  As Admin,
  I want to Edit Owner
  In order to add Pets

  Background: User navigates to Petclinic Home page
    Given I am on the home page with  URL "http://localhost:8080/petclinic/"
    Then I should see Home Page

  Scenario: Add First Pet
    When I Navigate to  Search Owner
      And I fill in Last Name "Tidke"
       And I click on Find Owner
        And I click  on name "Ganesh Tidke"
        And I cick on Add new Pet
        And Enter pet name "Dabra"
        And Select Birthdate "2018/02/25"
        And Select Pet type "cat"
        And Click on Add Pet
        Then I should see the pet added in  the list

        
  Scenario: Add Second Pet
    When I Navigate to  Search Owner
      And I fill in Last Name "Kumar"
       And I click on Find Owner
        And I click  on name "Gaurav Kumar"
        And I cick on Add new Pet
        And Enter pet name "Duggu"
        And Select Birthdate "2018/04/25"
        And Select Pet type "cat"
        And Click on Add Pet
        Then I should see the pet added in  the list