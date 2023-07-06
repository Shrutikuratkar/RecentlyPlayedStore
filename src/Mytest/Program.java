package Mytest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwaeTesting\\Driver1\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://Amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(enabled=false)
	public void verifyTitle() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Amazon.com";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println();

	}

	@Test
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
