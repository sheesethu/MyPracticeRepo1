package MavenTestNgPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUser {
WebDriver driver;
	
	@BeforeMethod
	
	public void launchApp() throws Exception
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\sheeba.kizhakkethil\\OneDrive - Accenture\\Growskill\\Jar\\chromedriver.exe");
		  driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
	}
	//run priority wise 
	@Test(priority = 3, description = "Verify elements are displayed",groups = "smoke")
	public void ts1()
	{
		boolean emailDisp = driver.findElement(By.id("email")).isDisplayed();
		if(emailDisp==true)
		{
			System.out.println("elements displayed,Pass");
		}
		
		boolean passDisp = driver.findElement(By.id("pass")).isDisplayed();
		if(passDisp==true)
		{
			System.out.println("Pass");
		}
	}
	
	@Test(priority = 2, description = "Verify elements are enabled",groups = "smoke")
	public void ts2()
	{
		boolean emailclick = driver.findElement(By.id("email")).isEnabled();
		if(emailclick==true)
		{
			System.out.println("elements enabled, Pass");
		}
		
		boolean passClick = driver.findElement(By.id("pass")).isEnabled();
		if(passClick==true)
		{
			System.out.println("Pass");
		}
	}
	
	@Test(priority = 1, description = "Login FB")
	public void ts3()
	{
		driver.findElement(By.id("email")).sendKeys("sheeba@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("pass");
		driver.findElement(By.name("login")).click();
	}
	
	
	@AfterMethod(groups = "smoke")
	public void close()
	{
		driver.close();
	}
	


}
