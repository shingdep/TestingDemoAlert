package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopup 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
	}
		
	@Test
	public void tc() throws InterruptedException
	{
		
		//scrolling page upto alert link
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)"," ");
		
		//click alertpopup link
		Thread.sleep(5000);
		driver.findElement(By.id("alert1")).click();
		
		Thread.sleep(5000);
		String alert=driver.switchTo().alert().getText();
		System.out.println(alert);
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

	}

}
