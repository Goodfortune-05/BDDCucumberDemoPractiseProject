Feature: Place the order for Products
@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is oon GreenCart Landing Page
When user searched with Shortname <Name> and extracted the actual name of the product
And Added 3 items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name     |
| Tom      |



