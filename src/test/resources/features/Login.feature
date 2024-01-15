Feature: Login

    Scenario: Login with valid credentials
        Given a user is on the login page
        When the user enters their username as "<username>"
        When the user enters their password as "<password>"
        And the user clicks on the login button
        Then the user should be logged and redirected to their dashboard