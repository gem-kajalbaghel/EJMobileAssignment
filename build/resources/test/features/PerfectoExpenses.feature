@Feature-Regression
Feature: Mobile Automation

  Background: Launch mobile application
    Given Application is launched
    Then Verify "Perfecto Expense Tracker" heading displays

  @launch
  Scenario: Verify mobile application launched successfully
    Then Verify "Perfecto Expense Tracker" heading displays

  @login
  Scenario: Perfecto Expense Tracker Login
    Then Verify "Perfecto Expense Tracker" heading displays
    When User clicks on "Sign Up" button
    Then Enter "sampleName" in "name" field
    Then Enter "sampleEmail@gmail.com" in "email" field
    Then Enter password in "password" field
    Then Enter password in "confirm password" field
    Then Select "INR" from "currency" dropdown
    When User clicks on "Register" button
    Then Enter "sampleEmail@gmail.com" in "login email" field
    Then Enter password in "login password" field
    When User clicks on "Login" button
    Then Verify Expenses page displays
