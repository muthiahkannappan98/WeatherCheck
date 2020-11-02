package Library;

import static org.junit.Assert.fail;

/*Name and Details: User created exception for the temperture diiference
created: 11/1/2020
author: muthiah.kannappan*/

public class TempException extends Exception {

	TempException(String s) {
		super(s);
		fail(s);
	}
}
