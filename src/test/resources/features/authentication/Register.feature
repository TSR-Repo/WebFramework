Feature: Registration

    Scenario: User registration
        Given a user is on is on home page
        When the user navigates to the account page
        And the user enters a username as "<username>"
        And the user enters a email as "<email>"
        And the user enters a password as "<password>"
        And the user clicks on the Register button
        Then the user should be logged in and redirected to their account page