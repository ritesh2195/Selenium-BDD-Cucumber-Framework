Feature: Login Feature

  Background: Prerequisite Steps

    Given user is on login page

  @login
  Scenario: Login using valid credentials

    When user enters email "your emil" and click on continue button
    And User enters password "password"
    And user clicks on sign in button
    Then user should be able to login in the application

  @login
  Scenario: login using invalid email id or mobile no

    When user enters wrong email "abcgugsd@gmail.com" and click on the continue button
    Then user should get alert message with alert icon
