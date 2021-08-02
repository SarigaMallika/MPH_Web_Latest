Feature: Validate login negative functionality

  #User must click on the login and validate validation messages should be displayed
  Scenario: Validate that the user is not allowed to login when Phone number and Password fields are blank
    Given launch URL and clicks on login button
    Then verify validation message

  Scenario: Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page
    When enters invalid phone no and password
    Then validation message is displayed 

  Scenario: Validate that user is not allowed to enter more than 10 digits in the 'Phone number' field
    When enters phone no with more than ten digits
    Then validation message is displayed

  Scenario: Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password'
    When enters invalid phone no and valid password
    Then validation message is displayed

  Scenario: Validate that the user is not allowed to login with invalid Password and valid phone number
    When enters invalid password and valid phone no
    Then validation message is displayed

  Scenario: Validate that user is not able to login on leaving 'Phone number' field blank and only giving valid 'Password'
    When enters phone no as  blank field
    Then validation message is displayed

  Scenario: Validate that user is not able to login on leaving 'Password' field blank and only giving valid 'Phone number'
    When enters password as  blank field
    Then validation message is displayed
