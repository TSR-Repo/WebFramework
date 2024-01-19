Feature: Checkout

    Background:
        Given a user is logged in
        And the user is on the store page
    @product
    Scenario Outline: Checkout
        When the user navigates to the cart page
        And the user clicks on Proceed to Checkout button
        And the user fills in "<firstName>", "<lastName>", "<companyName>", "<country>", "<streetAddress>", "<town>", "<PINCode>", and "<phone>"
        # And the user clicks on Place Order button
        # And the user should see the message "Thank you. Your order has been received."

        Examples:
            | firstName | lastName | companyName | country | streetAddress | town     | PINCode | phone      |
            | Adeba     | Joy      | Ts          | Burundi | 561           | Kibitoki | 999999  | 2540000000 |

