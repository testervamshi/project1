package Oct23;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar2 {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,150)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		String date="18/Nov/2024";//dd/MMM/yyyy or 18/11/2024  dd/MM/yyyy
		
		driver.findElement(By.id("first_date_picker")).click();
		
		Calendar calendar=Calendar.getInstance();
		
		SimpleDateFormat dateformat;
		try {
	
		dateformat=new SimpleDateFormat("dd/MMM/yyyy");
		
		dateformat.setLenient(false);//it will show exception when invalid date format is given
		
		Date formatteddate=dateformat.parse(date);
		
		calendar.setTime(formatteddate);
		System.out.println(formatteddate);
		
		}catch(Exception e){
			throw new Exception("date is invalid");
			
		}
		int targetday=calendar.get(calendar.DAY_OF_MONTH);
		int targetmonth=calendar.get(calendar.MONTH);
		int targetyear=calendar.get(calendar.YEAR);
		
		String currentdate=driver.findElement(By.className("ui-datepicker-title")).getText();
		
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentdate));//separating current date
		
		int currentmonth=calendar.get(calendar.MONTH);
		int currentyear=calendar.get(calendar.YEAR);
		
		//select future date
		while(currentmonth<targetmonth||currentyear<targetyear) {
			
			driver.findElement(By.className("ui-datepicker-next")).click();
			currentdate=driver.findElement(By.className("ui-datepicker-title")).getText();
			
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentdate));//separating current date
			
			currentmonth=calendar.get(calendar.MONTH);
			currentyear=calendar.get(calendar.YEAR);
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+targetday+"]")).click();
	}

}
