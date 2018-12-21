@web
Feature: Verify the Title of our web aplication
  As acceptance test we want to verify the title of the Home Page
  
  @facebook
  Scenario: Verify the Title of the Home Page
    Given User is on the langing page
    When User checks the title
    Then It must say "Facebook - Log In or Sign Up"
    