package Framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tc1 {
	@BeforeMethod
	void login() {
		System.out.println("this is login");
		
	}
	@Test(priority=1)
	void search() {
		System.out.println("this is search");
	}
	@Test(priority=2)
	void addproduct() {
		System.out.println("this is addproduct");
	}
	@AfterMethod
	void logout() {
		System.out.println("this is logout");
	}

}
