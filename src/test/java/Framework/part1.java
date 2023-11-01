package Framework;

import org.testng.annotations.Test;

public class part1 {
	
	@Test(priority=1)
	void openapp() {
		System.out.println("test step 1");
		
	}
	@Test(priority=10)
	void login() {
		System.out.println("test step 2");
		
	}
	@Test(priority=15)
	void close() {
		System.out.println("test step 3");
		
	}
	

}
