package Store_tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_tests.BaseTest02;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class eCommerence_tc_4_Hybrid extends BaseTest02 {

	
	@Test
	public void FillForm() throws InterruptedException 
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Veronika");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Czech Republic\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Czech Republic']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); //ADD TO CARD se změni na ADDED. poté máme na obrazovce pouze jeden index pro ADD
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1])")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	

		List <WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;
		for(int i = 0; i < count; i++) 
		{
			String amountString = productPrices.get(i).getText();
			//$160.07 dej mi string, který začíná od indexu 1 (odstraníme dolar)
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		Assert.assertEquals(totalSum, displayFormattedSum, 0.0);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(3000);
		
		/*
		 * získání názvu webové a nativní části aplikace
		 * Set<String>contexts = driver.getContextHandles(); for(String
		 * contextName:contexts) { System.out.println(contextName); }
		 */
		Set<String>contexts = driver.getContextHandles();
		for(String contextName:contexts)
			{ 
			System.out.println(contextName); 
			}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		scrollCookies();
		driver.findElement(By.xpath("//div[@role='none'][contains(text(),'Přijmout vše')]")).click();
		driver.findElement(By.name("q")).sendKeys("utb");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
	}
	
	
}
