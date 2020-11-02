package Library;

import java.util.Comparator;

public class WeatherComparator implements Comparator<Weather> {
	
	/*Name and Details: Comparator to compare two degrees from weather objects and throws exception if difference is not with in variable value excepted
	 created: 11/2/2020 
	 retrurn type: int
	 author: muthiah.kannappan*/
	
	public int compare(Weather w1, Weather w2) {
		float degflag = Math.abs(w1.getDegree() - w2.getDegree());
		if (degflag >= Float.parseFloat(FunctionLibrary.data.get(1))) {
			try {
				throw new TempException(w1.getDegree() + " and " + w2.getDegree()
						+ " Degree are not having difference between " + FunctionLibrary.data.get(1));
			} catch (Exception e) {
				System.out.println("Catch Block");
				System.out.println(e);
			}
		}
		return 0;

	}

}