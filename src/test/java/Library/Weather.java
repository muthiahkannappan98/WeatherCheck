package Library;

public class Weather {
	private String city;
	private int humidity;
	  private int degree;
	  
	  public Weather() {}
	  
	public String getCity() { return city; }
	  public void setCity(String city) {
	    this.city = city;
	  }
	  
	  public int getHumidity() { return humidity; }
	  public void setHumidity(int humidity) {
	    this.humidity = humidity;
	  }
	 
	  public int getDegree() { return degree; }
	  public void setDegree(int degree) {
	    this.degree = degree;
	  }

}
