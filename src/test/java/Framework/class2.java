package Framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class class2 {
	
	@Test
	void xyz() {
		System.out.println("this is xyz mthod in class2");
	}
	@AfterTest
	void n() {
		System.out.println("this is n mthod in class2");
	}

}
