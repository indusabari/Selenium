package day2test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testing {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Indu\\Selenium\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	
	//@DataProvider
	public Object[][] dataProviderMethod()
	{
		Object[][] obj = {
				{"mercury","mercury"},
				{"mercury1","mercury1"}
				};
		return obj;
	}
	
	  
	@Test(priority=1)
	public void testrun()
	{
		
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//label[contains(text(),'PNR STATUS')]")).click();
		Set<String> win=driver.getWindowHandles();
	
		for(String s:win)
		{
			
			driver.switchTo().window(s);
			
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("inputPnrNo")).sendKeys("123");
		System.out.println("PNR Status entered time=="+driver.findElement(By.id("curDate")).getText());
		Assert.assertEquals("asd", "asdc");
	}
	
	@Test(priority=2, dependsOnMethods="testrun")
	public void testrun2() {
		driver.manage().window().maximize();
	    driver.get("https://www.hdfcbank.com/");
	    
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    Actions act = new Actions(driver);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement apply = driver.findElement(By.xpath(".//span[contains(text(),'Apply now')]"));
		
		act.moveToElement(apply).perform();
		//WebDriverWait wait= new WebDriverWait(driver, TimeUnit.SECONDS);
		WebElement cc = driver.findElement(By.linkText("Credit Card"));
		act.moveToElement(cc).click().perform();
		}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	

}
