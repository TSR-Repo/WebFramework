@showcase
Feature: Search Product

    Background:
        Given a user is logged in
        And the user is on the store page

    Scenario Outline: Search a product in the store
        When the user enters a "<search_term>"
        And the user clicks on the search button
        Then the products containing the "<search_term>" should be displayed

        Examples:
            | search_term |
            | Jeans       |
            | Blue        |
