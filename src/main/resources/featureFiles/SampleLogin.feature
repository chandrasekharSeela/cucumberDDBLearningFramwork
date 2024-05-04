Feature: Sample Login Demo Application

  Background: open URL
    Given Open the Application URL

  Scenario Outline: Login to the Application
    Given Click on Login button
    And Enter the valid credentials "<userName>" and "<Password>"
    Then verify the landed on home page or not
    And signOut and close the browser

    Examples:
      | userName                        | Password |
      | Seela.chandrasekhar@outlook.com | Abc@2021 |

  Scenario Outline: search for Job
    Given Click on Login button
    And Enter the valid credentials "<userName>" and "<Password>"
    Then verify the landed on home page or not
    When Enter job "<title>" and "<postcode>"
    And signOut and close the browser


    Examples:
      | userName                        | Password | title         | postcode |
      | Seela.chandrasekhar@outlook.com | Abc@2021 | Selenium Java | Glasgow  |
