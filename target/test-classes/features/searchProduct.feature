Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is oon GreenCart Landing Page
When user searched with Shortname <Name> and extracted the actual name of the product
Then user searched for <Name> shortname in offers page 
And validate product name in offers page matches with landing page

Examples:
| Name     |
| Tom      |
| Beet     |


