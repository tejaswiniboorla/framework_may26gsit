@addCart
Feature: Validate add to cart functionality 

Scenario: Validate add to cart
 	Given user is home page
	When clicks login
	And  user enters email "priyankauser@gmail.com" and password "Priyanka@1"
	Then user is sucessfully logged in
	And user is on search screen and in stock is checked
   	Given clear filter is applied
   	When user search flower "Rose" and quantity "3"
   	Then validate correct item is added 
   	And  validate correct item quantity