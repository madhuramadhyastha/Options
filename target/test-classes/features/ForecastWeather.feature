Feature: Validating forecast API is providing the results as per the end point.

Scenario: Verify if the forecast for 5 days are shown if the user searches by city name.

        Given user sets up a request
        When user calls forecast api with weather for day
        When user calls forecast api with city
 
        