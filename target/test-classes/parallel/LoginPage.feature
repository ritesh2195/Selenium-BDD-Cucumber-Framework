Feature: Login Feature

  Background: Prerequisite Steps

    Given user is launching amazon application url
    And User clicks on the SignIn link

  @login
  Scenario: Login using valid credentials

    When user enters email "dshisdhdsu" and click on continue button
    And User enters password "sdhuhdihdis"
    When user clicks on sign in button
    Then user should be able to login in the application

  @login
  Scenario: login using invalid email id or mobile no

    When user enters wrong email "abcucgugsd@gmail.com" and click on the continue button
    Then user should get alert message with alert icon
