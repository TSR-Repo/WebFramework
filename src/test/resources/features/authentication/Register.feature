Feature: Registration

    Scenario: User registration
        Given a user is on is on home page
        When the user navigates to the account page
        And the user enters their username as "<username>"
        And the user enters their email as "<email>"
        And the user enters their password as "<password>"
        And the user clicks on the Register button
        Then the user should be registered and logged in