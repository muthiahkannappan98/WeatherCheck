package StepDefinition;

import Library.FunctionLibrary;
import cucumber.api.java.en.When;

public class RestPage extends FunctionLibrary {
	
	@When("^Get Temparature using API$")
	public void get_Temparature_using_API() throws Throwable {
		getResponseBody("https://api.openweathermap.org/data/2.5/weather");
		result.then().assertThat().statusCode(200);
	}

	@When("^Compare temperatures from UI and API$")
	public void compare_temperatures_from_UI_and_API() throws Throwable {
		api.setCity(result.then().extract().path("name").toString());
		api.setDegree(Integer.parseInt(result.then().extract().path("main.temp").toString()));
		api.setHumidity(Integer.parseInt(result.then().extract().path("main.humidity").toString()));
	}
}
