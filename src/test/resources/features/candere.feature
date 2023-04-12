@ui @candere


Feature: E-commerce ProjectWeb Site online jewellery shopping

Background: Navigate common scenario
Given User navigate for a landing page

@validate_LandingPage
Scenario: User is able to open the application 
Then validate the landing page

@search
Scenario: User is able to open the application and able to perform a search operations
When user search a a product "majestic solitaire diamond ring"

@validate
Scenario: User is able to select and click the product
When user search a a product "majestic solitaire diamond ring"
When User select and click the product name in the landing page
Then  validate the product discription
Then User Select ring size
Then Validate the Price Update

@AboutUs
Scenario: Validate footer section
When Scroll down the landing page 
And validate aboutus section of the landing page
| About Our Company    |
| Terms and Conditions |
| Privacy Policy 	     |
| FAQ               	 |
| Offers T&Cs 				 |
| Customer Reviews 	 	 |


@footer
Scenario: User is able to open the application and click to facebookbtn
And user select fb button
#And browser is closed