package DemoApp_tests;

import java.net.MalformedURLException;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Appium_tests.BaseTest02;
import Appium_tests.BaseTest01;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TC_06 extends BaseTest01{

    @Test
	public void Miscellanous() throws MalformedURLException {
    	//directly to the page we want
    	Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies"); 	
    	((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
        driver.findElement(By.id("android:id/checkbox")).click();
        //landscape mode
        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);
        
        //tagName se nachází na stránce 2x, proto použijeme druhý index, jinak by se první otevřel první index
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
        
        
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        //copy paste
        //copy to clipboard - paste it clipboard (clipboard testing)
        driver.setClipboardText("Veronika WiFi"); //copy
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText()); //paste
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        //máme více elemtů co mají stejný classname, podíváme se jaký index má button OK a pomocí get ho vybereme
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        
        
        
        
        
        //set wifi name

       
    }
}
