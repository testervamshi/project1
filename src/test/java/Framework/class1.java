package Framework;

import org.testng.annotations.*;

public class class1 {
	@Test
	void abc() {
		System.out.println("this is abc in class1");
	}
	@BeforeTest
	void m() {
		System.out.println("this is m mthod in class1");
	}

}
