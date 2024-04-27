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


import Appium_tests.BaseTest01;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TC_05 extends BaseTest01{

    @Test
	public void DragDropTest() throws MalformedURLException, InterruptedException  
    {
    	
       driver.findElement(AppiumBy.accessibilityId("Views")).click();
       driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
       WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
       ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
           "elementId", ((RemoteWebElement) source).getId(),
           "endX", 829,
           "endY", 752
       ));
       Thread.sleep(3000);
       String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
       Assert.assertEquals(result, "Dropped!");
       
    }
}
