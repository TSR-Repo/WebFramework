@log
Feature:Logout
@logout
Scenario: Logout
        Given a user is logged in
        And the user is on account page
        When the user clicks on Logout link
        Then the user should be logged out 

