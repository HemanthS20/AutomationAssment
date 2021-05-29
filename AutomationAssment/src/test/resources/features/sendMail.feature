@sample
  Feature: sending an email using Gmail

      Scenario: Send the email in Gmail

        Given the user is able to access the application
        When user log in to application with valid credentials
        And user will compose the new mail
        Then User with send the mail