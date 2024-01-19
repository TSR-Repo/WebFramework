@showcase
Feature: Edit Profile
   Scenario Outline: The user updates the Profile
      Given a user is logged in
      When the user clicks on the Account details link
      When the user adds "<new_first_name>", "<new_last_name>", and "<new_display_name>"
      And the user clicks on Save Changes
      Then the update should be successful with message "Account details changed successfully."

      Examples:
         | new_first_name | new_last_name | new_display_name |
         | John           | Doe           | Joe              |