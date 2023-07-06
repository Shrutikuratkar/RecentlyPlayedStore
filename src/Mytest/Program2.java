package Mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program2 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwaeTesting\\Driver1\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test
	public void verifyTitle() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Daily Gainers: BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println();

	}

	@Test
	// (enabled=false)
	public void verifyLogo() {
		boolean flag = driver.findElement(By.xpath("//a[contains(text(),'Karnataka Bank')]")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println("Thank You God For This");
	}

	@Test
	public void RowCheck() {
		driver.findElement(By.xpath("//a[contains(text(),'Karnataka Bank')]/ancestor::tr")).getText();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
