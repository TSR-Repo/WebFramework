@EditProfile
Feature: Edit Profile
 Scenario: The user updates the Profile
    Given A user is logged in 
    When the user clicks on the Account details link
    When the user fills the form 
    And the user clicks on Save Changes
    Then the user should be notified about the updates




 