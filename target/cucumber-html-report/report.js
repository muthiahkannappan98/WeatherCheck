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
  "duration": 6424524299,
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
  "duration": 3533831400,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.navigate_to_weathers_tab()"
});
formatter.result({
  "duration": 2398572399,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.search_for_the_city()"
});
formatter.result({
  "duration": 2855192301,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.validate_the_city_in_map()"
});
formatter.result({
  "duration": 144571699,
  "status": "passed"
});
formatter.match({
  "location": "MapPage.check_for_other_paramerters_of_report()"
});
formatter.result({
  "duration": 418800300,
  "status": "passed"
});
formatter.match({
  "location": "RestPage.get_Temparature_using_API()"
});
formatter.result({
  "duration": 2275544100,
  "status": "passed"
});
formatter.match({
  "location": "RestPage.compare_temperatures_from_UI_and_API()"
});
formatter.result({
  "duration": 706904300,
  "status": "passed"
});
formatter.after({
  "duration": 55199,
  "status": "passed"
});
});