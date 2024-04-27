package Browser_tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

	@Test
	public void browserTest() throws InterruptedException
	{
		/*
		 * driver.get("http://google.com"); 
		 * scrollCookies(); 
		 * driver.findElement(By.xpath("//div[@role='none'][contains(text(),'Přijmout vše')]")).click();
		 * System.out.println(driver.getTitle());
		 * driver.findElement(By.name("q")).sendKeys("utb");
		 * driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 */
		
		driver.get("https://www.utb.cz/");
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wt-cli-accept-btn")));
		driver.findElement(By.id("wt-cli-accept-btn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Fakulty a součásti')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Fakulta aplikované informatiky')]"))); 
		driver.findElement(By.xpath("//h3[contains(text(),'Fakulta aplikované informatiky')]")).click();
		Thread.sleep(2000);
		
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".main-logo.pull-left")));
		String text = driver.findElement(By.cssSelector(".main-logo.pull-left")).getText();
		Assert.assertEquals(text, "Fakulta aplikované informatiky");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)");

		String mapText = driver.findElement(By.xpath("//a[normalize-space()='Mapa stránek']")).getText();
		Assert.assertEquals(mapText, "Mapa stránek");
		Thread.sleep(5000);
		
		
	}
}
