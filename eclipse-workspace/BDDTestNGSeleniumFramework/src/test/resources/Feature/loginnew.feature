Feature: Login functionality 
@login
Scenario Outline:Check the Login functionality
Given User is on login page
When user enters "<username>" and "<password>"
And clicks on login button
Then user should navigated to home page
Examples:
| username | password |
| standard_user |secret_sauce |
