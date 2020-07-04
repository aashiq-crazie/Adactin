Feature: Testing hotel booking and cancellation functionalites in adactin application

Background:
    Given the user is logged in
    And goes to landing page


@login
Scenario: Checking the valid username and password for login function
Given User launch the adactin application
When User enter the valid username
And User enter the valid password
And User enter the login button
Then It lands to the homepage successfully

@SearchHotel
Scenario: User searching the required hotel for lovable stay
Given User select the required location
When User select the number of rooms
And User mentioning checkin date
And User mentioning checkout date
And User selecting adults per room
And User enter the search button
Then It lands to the nextpage succesfully

@SelectHotel
Scenario: User selecting hotel in that specific location
Given User select his favourite hotel
When User enter the continue button
Then It lands to the nextpage succesfully

@BookHotel
Scenario: User mentioning details to book the hotel
Given User mentioning firstname
When User mentioning lastname
And User mentioning billing address
And User mentioning creditcard number
And User selecting creditcard type
And User mentioning month of expiry
And user mentioning year of expiry
And User mentioning the cvv number
And User enter the booknow button
Then It lands to nextpage succesfully

@BookingConfirmartion
Scenario: User validating booking confirmation page
Given User enter the myitenary button
Then It lands to nextpage succesfully

@CancelHotel
Scenario: User selecting hotel for cancellation
Given User selecting reqiured hotel to cancel

@CancelConfirmation
Scenario: User entering cancelbutton and confirming the cancellation
Given User enter the cancel button
When user confirming the cancellation
Then It loads to nextpage succesfully

@Logout
Scenario: User logout the page
Given User enter the logoutbutton
Then It loads to final page succefully





