package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo 
{
	WebDriver driver;

	@BeforeSuite
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium All Driver\\chrome\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@BeforeTest
	public void enterUrl()
	{
		driver.get("http://www.newtours.demoaut.com/");
	}
	
	
	@BeforeClass
	public void managePage()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void test() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("QQQQQ");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("qqqqq");
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
	
	}
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("all the methods are executed successfully");
	}
	
	
	
}
