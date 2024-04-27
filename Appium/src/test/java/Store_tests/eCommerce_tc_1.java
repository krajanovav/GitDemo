package Store_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_tests.BaseTest02;
import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest02{

	
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

	//	String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	//	Assert.assertEquals(toastMessage, "Please enter your name");
	}
}
