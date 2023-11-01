package Oct23;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenders {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		int day=2;
		String month= "December 2024";
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,150)", "");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		//calender 6
		driver.findElement(By.id("sixth_date_picker")).sendKeys("09/22/2023");
		
		//calender 1 select date from current month
		driver.findElement(By.id("first_date_picker")).click();
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+day+"]")).click();
		
		//calender 2 select date from current month when it has previous and future dates
		driver.findElement(By.id("second_date_picker")).click();
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' ui-datepicker-other-month '))]//a[text()="+day+"]")).click();
		
		
		//calender 1 select future date
		driver.findElement(By.id("first_date_picker")).click();
		
		while(true) {
			String currentdate=driver.findElement(By.className("ui-datepicker-title")).getText();//gives you current month
			if(currentdate.equals(month)) {
				break;
			}else {
				driver.findElement(By.className("ui-datepicker-next")).click();//click on next until reach required month
			}
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+day+"]")).click();//selects the date

	}

}
