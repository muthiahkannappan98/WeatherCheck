package Library;

/*Name and Details: Weather class with its attributes 
created: 11/1/2020
author: muthiah.kannappan*/

public class Weather {
	private String city;
	private float humidity;
	private float degree;

	public Weather() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getDegree() {
		return degree;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}

}
