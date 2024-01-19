Feature: Add to Cart

    Background:
        Given a user is logged in
        Given the user is on the store page

    Scenario Outline: Add a product to cart
        When the user adds a "<product_name>" to cart
        And the user navigates to cart
        Then the added "<product_name>" should be present in the cart

        Examples:
            | product_name     |
            | Anchor Bracelet  |
            | Basic Blue Jeans |