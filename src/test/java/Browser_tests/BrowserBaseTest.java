package Browser_tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		 //code to start server
    	// Android Driver, IOSDriver
    	// Appium code -> Appium Server -> Mobile
	  service = new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/Veronika/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
	    		.withIPAddress("127.0.0.1").usingPort(4723).build();
	    	service.start();
	    	
	      	UiAutomator2Options options = new UiAutomator2Options();
	        options.setDeviceName("VeronikaEmulator");
	        options.setChromedriverExecutable("V:\\Skola\\BP\\Appium-BP\\ChromeDriver\\chromedriver.exe");
	        options.setCapability("browserName", "Chrome");
	        
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        //actual automation
	}
	
	
	public void scrollCookies() {
	    boolean canScrollMore;
	    do {
	        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	            "left", 660, // x souřadnice pro střed dropdown menu
	            "top", 1300, // y souřadnice pro střed dropdown menu
	            "width", 100, // šířka oblasti pro scrollování
	            "height", 500, // výška oblasti pro scrollování
	            "direction", "down",
	            "percent", 30.0 //
	        ));
	    } while(canScrollMore);
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	public void shutDown()
	{
        driver.quit();
        service.stop();
	}
	
}
