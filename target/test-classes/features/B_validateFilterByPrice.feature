@filterByPrice
Feature: Validating price by filter functionality

Scenario Outline: Validating price by filter
  Given user is home page
  When clicks login
  And user enters email "priyankauser@gmail.com" and password "Priyanka@1"
  Then user is sucessfully logged in
  Given user is on search screen and in stock is checked
  When Range <range> is selected
  Then price is validated

Examples:
| range|
| "Below ₹60"|
| "₹60 - ₹70"|
| "Above ₹70"|