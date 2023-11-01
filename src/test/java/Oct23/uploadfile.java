package Oct23;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class uploadfile {

	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		
		//upload file using send keys method
		//driver.findElement(By.className("upload_txt")).sendKeys("C:\\Users\\ADMIN\\Desktop\\W3S_Vamshi\\Documents\\Manual\\Agile Model.docx");
		
		//upload file using robot class
		WebElement ele=driver.findElement(By.className("upload_txt"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();
		
		//creating robot class
		Robot Rb=new Robot();
		
		//copy the file from local folder
		StringSelection ss=new StringSelection("C:\\Users\\ADMIN\\Desktop\\W3S_Vamshi\\Documents\\Manual\\Agile Model.docx");//select the file
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);//copy the file
		
		//pasting by ctrl+v
		Rb.keyPress(KeyEvent.VK_CONTROL);
		Rb.keyPress(KeyEvent.VK_V);
		
		//release the key
		Rb.keyRelease(KeyEvent.VK_CONTROL);
		Rb.keyRelease(KeyEvent.VK_V);
		
		//press enter key to upload the file
		Rb.keyPress(KeyEvent.VK_ENTER);
		
		Rb.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
