package StepDefinition;

import Library.FunctionLibrary;
import cucumber.api.java.en.When;

public class RestPage extends FunctionLibrary {

	@When("^Get Temparature using API$")
	public void get_Temparature_using_API() throws Throwable {
		getResponseBody("https://api.openweathermap.org/data/2.5/weather?q=" + data.get(0) + "&");
		result.then().assertThat().statusCode(200);
	}

	@When("^Compare temperatures from UI and API$")
	public void compare_temperatures_from_UI_and_API() throws Throwable {
		api.setCity(result.then().extract().path("name").toString());
		api.setDegree(Float.parseFloat(result.then().extract().path("main.temp").toString().replaceAll("[^0-9.]", "")));
		api.setHumidity(
				Float.parseFloat(result.then().extract().path("main.humidity").toString().replaceAll("[^0-9.]", "")));
		compareObjects();
	}
}
