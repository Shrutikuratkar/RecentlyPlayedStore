package Mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdvancedXpath {
	
	public class Program {
		WebDriver driver;

		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "D:\\SoftwaeTesting\\Driver1\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			String text = driver.findElement(By.xpath("//a[contains(text(),'HDFC Bank')]")).getText();
			System.out.println(text);

		}
		@Test(enabled=false)
		public void verifyTitle() {
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "Daily Gainers: BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks";
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			System.out.println();

		}
		
		/*
		 * @AfterMethod public void tearDown() { driver.close(); }
		 */

}
}
