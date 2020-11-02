package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\mukannap\\git\\WeatherCheck\\src\\test\\resources\\Features\\WeatherCheck.feature", glue = "StepDefinition", plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" }, monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {

}