#Author: your.email@your.domain.com
#To compare weather information from UI & API


Feature: Compare weather information from NDTV UI & Openweathermap API
  Scenario: Compare weather information scenario
    Given Launch NDTV page
    And Navigate to weathers tab
    When Search for the city
    Then Validate the city in map
    And check for other paramerters of report
    When Get Temparature using API
    And Compare temperatures from UI and API
