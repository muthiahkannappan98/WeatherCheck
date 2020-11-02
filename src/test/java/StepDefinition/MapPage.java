package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Library.FunctionLibrary;

public class MapPage extends FunctionLibrary {

	@Before()
	public void beforeScenario() throws IOException {
		data = loadExcelData();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After()
	public void afterScenario() {
		driver.quit();
	}

	@Given("^Launch NDTV page$")
	public void launch_NDTV_page() throws Throwable {
		driver.navigate().to("https://www.ndtv.com/");
		String title = driver.getTitle();
		Assert.assertThat(title, CoreMatchers.containsString("NDTV"));
	}

	@Given("^Navigate to weathers tab$")
	public void navigate_to_weathers_tab() throws Throwable {
		clickWebElement(driver.findElement(By.xpath("//*[@id='h_sub_menu']")), "More navigation");
		clickWebElement(driver.findElement(By.xpath("//*[@class='topnav_cont']/a[contains(text(),'WEATHER')]")),
				"Weather Link");
		String title = driver.getTitle();
		Assert.assertThat(title, CoreMatchers.containsString("NDTV Weather"));
		System.out.println("Navigate to weathers tab is successful");
	}

	@When("^Search for the city$")
	public void search_for_the_city() throws Throwable {
		waitForElement("//*[@class='cityText'][contains(text(),'New Delhi')]");
		waitForElement("//*[@id='" + data.get(0) + "']");
		if (!driver.findElement(By.xpath("//*[@id='" + data.get(0) + "']")).isSelected()) {
			clickWebElement(driver.findElement(By.xpath("//*[@id='" + data.get(0) + "']")), "Select city");
		}
		System.out.println("City search " + data.get(0) + " is successful");
	}

	@Then("^Validate the city in map$")
	public void validate_the_city_in_map() throws Throwable {
		waitForElement("//*[@class='cityText'][contains(text(),'" + data.get(0) + "')]");
		clickWebElement(driver.findElement(By.xpath("//*[@class='cityText'][contains(text(),'" + data.get(0) + "')]")),
				"Select city in MAP");
		Assert.assertTrue(checkWebElement(
				driver.findElement(By.xpath("//*[@class='cityText'][contains(text(),'" + data.get(0) + "')]")),
				"City displayed in MAP view" + data.get(0)));
		System.out.println("City found " + data.get(0) + " in map");
	}

	@Then("^check for other paramerters of report$")
	public void check_for_other_paramerters_of_report() throws Throwable {
		waitForElement("//*[@id='map_canvas']//span[1]/b[contains(text(),'Condition')]");
		Assert.assertTrue(checkWebElement(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[1]/b[contains(text(),'Condition')]")),
				"Condition displayed in MAP weather view of " + data.get(0)));
		Assert.assertTrue(checkWebElement(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[2]/b[contains(text(),'Wind')]")),
				"Wind displayed in MAP weather view of " + data.get(0)));
		Assert.assertTrue(checkWebElement(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[3]/b[contains(text(),'Humidity')]")),
				"Humidity displayed in MAP weather view of " + data.get(0)));
		Assert.assertTrue(checkWebElement(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[4]/b[contains(text(),'Temp in Degrees')]")),
				"Temp in Degrees displayed in MAP weather view of " + data.get(0)));
		Assert.assertTrue(checkWebElement(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[5]/b[contains(text(),'Temp in Fahrenheit')]")),
				"Temp in Fahrenheit displayed in MAP weather view of " + data.get(0)));
		ui.setCity(data.get(0));
		ui.setDegree(getValue(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[4]/b[contains(text(),'Temp in Degrees')]"))));
		ui.setHumidity(getValue(
				driver.findElement(By.xpath("//*[@id='map_canvas']//span[3]/b[contains(text(),'Humidity')]"))));
		clickWebElement(driver.findElement(By.xpath("//*[@id='map_canvas']//a[contains(@class,'close')]")),
				"Close button");
		System.out.println("City details validated successfully for " + data.get(0));

	}
}
