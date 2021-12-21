#Author : Vinay Harel
#Date : 20-12-2021
#Description : Test compose functionality in gmail

Feature: Test Compose Option in gmail

  Scenario: User should be able to compose mail in gmail
  Given: browser is open
    And user navigates to gmail login page
    And enters valid username as "abc@gmail.com" and password as "password#"
    And User is landed on gmail home page
    When User clicks on Compose Button
    And enters email subject as "Incubyte"
    And body as "Automation QA test for Incubyte"
    And sender as "xyz@gmail.com" and clicks on send button
    Then Mail should be submitted successfully