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

public class TC_02 extends BaseTest01{

    @Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException 
    {
    	
       driver.findElement(AppiumBy.accessibilityId("Views")).click();
       
       //uiautomator - ui engine script vytvořím třídu která potřebuje argument který argument chci scrollovat, .scroll dá argument kam chci scrollovat
       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
       
       //scrollToEndAction();
    	   
    	   
       Thread.sleep(2000);

    }
}
