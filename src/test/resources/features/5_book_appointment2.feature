
@PetClinic
Feature: Booking an appointment for Pet
  As Admin,
  I want to book an appointment for pet
  In order to show the pet to veterninarians

  Background: User navigates to Petclinic Home page
    Given I am on the home page with  URL "http://localhost:8080/petclinic/"
    Then I should see Home Page

     
       Scenario: Book Second Appointment
    When I Navigate to  Search Owner
      And I fill in Last Name "Kumar"
       And I click on Find Owner
        And I click  on name "Gaurav Kumar"
        And I click  on name Add visit
        And Select Date as "2018/05/10"
        And Put description as "Fever"
        And Click on Add visit   