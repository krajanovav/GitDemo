package DemoApp_tests;

import java.net.MalformedURLException;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_tests.BaseTest02;
import Appium_tests.BaseTest01;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TC_01 extends BaseTest01{

    @Test
	public void WifiSettingName() throws MalformedURLException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
        driver.findElement(By.id("android:id/edit")).sendKeys("Veronika WiFi"); 
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
