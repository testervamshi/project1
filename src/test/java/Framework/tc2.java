package Framework;


import org.testng.Assert;
import org.testng.annotations.*;

public class tc2 {
	@BeforeClass
	void login() {
		System.out.println("this is login");
		
	}
	@Test(priority=1)
	void search() {
		Assert.assertFalse(true);
		System.out.println("this is search");
	}
	@Test(priority=2,dependsOnMethods= {"search"})
	void addproduct() {
		System.out.println("this is addproduct");
	}
	@AfterClass
	void logout() {
		System.out.println("this is logout");
	}

}
