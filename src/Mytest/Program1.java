package Mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwaeTesting\\Driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://Amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@Test
	public void selectDropDown() throws Exception {
		WebElement e=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		Select select=new Select(e);
		select.selectByIndex(3);
		System.out.println(select);
		Thread.sleep(3000);
	}
	@Test
	public void VerifySearchBar() {
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cloths");;
	//search.click();
	
		
	}

	@Test(enabled=false)
	public void verifyTitle() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Amazon.com";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println();

	}

	@Test(enabled=false)
	public void verifyLogo() {
		boolean flag = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println("Thank You God For This");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

