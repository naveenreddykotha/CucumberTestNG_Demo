
Feature: Login to HRM Application 
 
Background: 
   Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
  
   @ValidCredentials
   Scenario: Login with valid credentials
      
    When User enters username as "Admin" and password as "admin123"
    And user signup with following details
    | Naveen Reddy | Kotha | naveen@gmail.com | 7685752992 |
    | Naveen Reddy | Kotha | naveen@gmail.com | 7685752992 |
    
    Then User should be able to login sucessfully and new page open
     
   @InvalidCredentials
   Scenario Outline: Login with invalid credentials
      
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"
     
  Examples:
  | username   | password  | errorMessage                      |
  | Admin      | admin12$$ | Invalid credentials               |
  | admin$$    | admin123  | Invalid credentials               |
  