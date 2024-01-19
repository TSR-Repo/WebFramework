Feature: Filter Products

    Background:
        Given a user is logged in
        And the user is on the store page

    Scenario: Order products by price (Low to High)
        When the user filters products by price from low to high
        Then the products should display from the cheapest to the most expensive