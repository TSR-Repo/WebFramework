Feature: Add to Cart

    Background:
        Given a user is logged in

    Scenario Outline: Add a product to cart
        Given the user is on the store page
        When the user add a "<product_name>" to cart
        And the user clicks on view cart link
        Then the added "<product_name>" should be present in the cart