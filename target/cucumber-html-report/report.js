$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/mukannap/git/WeatherCheck/src/test/resources/Features/WeatherCheck.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#To compare weather information from UI \u0026 API"
    }
  ],
  "line": 5,
  "name": "Compare weather information from NDTV UI \u0026 Openweathermap API",
  "description": "",
  "id": "compare-weather-information-from-ndtv-ui-\u0026-openweathermap-api",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6734168100,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Compare weather information scenario",
  "description": "",
  "id": "compare-weather-information-from-ndtv-ui-\u0026-openweathermap-api;compare-weather-information-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Launch NDTV page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Navigate to weathers tab",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Search for the city",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Validate the city in map",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "check for other paramerters of report",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Get Temparature using API",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Compare temperatures from UI and API",
  "keyword": "And "
});
formatter.match({
  "location": "MapPage.launch_NDTV_page()"
});
formatter.result({
  "duration": 4702802300,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.navigate_to_weathers_tab()"
});
formatter.result({
  "duration": 1312917300,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.search_for_the_city()"
});
formatter.result({
  "duration": 3170008200,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.validate_the_city_in_map()"
});
formatter.result({
  "duration": 433868500,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.check_for_other_paramerters_of_report()"
});
formatter.result({
  "duration": 435351600,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 71500,
  "status": "passed"
});
});