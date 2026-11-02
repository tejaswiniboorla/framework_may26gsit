@login
Feature: Login functionality of registered user

Scenario: login via email and password
Given user is home page
When clicks login
And user enters email "priyankauser@gmail.com" and password "Priyanka@1"Then user is sucessfully logged in 