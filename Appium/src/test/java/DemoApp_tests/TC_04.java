package DemoApp_tests;

import java.net.MalformedURLException;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Appium_tests.BaseTest02;
import Appium_tests.BaseTest01;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TC_04 extends BaseTest01{

    @Test
	public void SwipeDemoTest() throws MalformedURLException  
    {
    	
       driver.findElement(AppiumBy.accessibilityId("Views")).click();
       driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
       driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
       WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
       Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
       swipeAction(firstImage, ("left"));
       Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");

    }
}
