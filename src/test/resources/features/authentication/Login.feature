@currentTest
Feature: Login

    Scenario: Login with invalid credentials
        Given a user in on the login page
        When the user enters the username as "<username>"
        And the user enters the password as "<password>"
        And the user clicks on login button
        Then the login should fail with the message as "<error_message>"

        Examples:
            | username          | password      | error_message                                            |
            | hello@morning.com | wrongpassword | Unknown email address. Check again or try your username. |