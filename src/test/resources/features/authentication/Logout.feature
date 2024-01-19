@showcase
Feature: Logout

    Background:
    Given a user is logged in

    Scenario: Logout
        Given the user is on account page
        When the user clicks on Logout link
        Then the user should be logged out

