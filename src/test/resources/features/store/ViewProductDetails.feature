Feature: Product Details

    Background:
        Given a user is logged in
    
    Scenario Outline: View Product Details
        Given the user is on the store page
        When the user clicks on a product with product name "<product_name>"
        Then the details of "<product_name>" should be displayed

        Examples:
            | product_name     |
            | Anchor Bracelet  |
            | Basic Blue Jeans |
