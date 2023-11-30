package common;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ExtentReportsUtil;
import utils.Logger;

public class BaseClass {
	public AndroidDriver driver;
	public static ITestResult result;
    	
	public static int failTC;
	MutableCapabilities capabilities = new UiAutomator2Options();
    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    
	
	String userName = System.getenv("BROWSERSTACK_USERNAME");
	String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
//	String app = System.getenv("BROWSERSTACK_APP_ID");
	String app = "bs://f80d14888f1cf7e503a7de6366ec985e13631d03";
	String URL2 = "http://" +  userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
	String URL = "http://vincealecserquen_PUL7Gx:6Nakjv6gG8CQfeyCxTHW@hub-cloud.browserstack.com/wd/hub";
	
    @BeforeSuite
	public void setupReport() {
		ExtentReportsUtil.startExtentReport("\\Reports\\Test.html");
	}  
    
    @BeforeTest(alwaysRun=true)
    public void setUpRunEnv() throws Exception {
    	failTC = 0;
    	browserstackOptions.put("appiumVersion", "2.0.1");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("deviceName", "Samsung Galaxy S21");
        capabilities.setCapability("os_Version", "12.0");
        capabilities.setCapability("Project", "Vince's BS iFinibo Automation");
        capabilities.setCapability("build", buildName);
        capabilities.setCapability("app", app);        
    }
    
    @BeforeMethod
    public void beforeMethod(Method m) throws Exception{
    	String testname = m.getName();
		System.out.println(testname);
		capabilities.setCapability("name", testname);
		driver = new AndroidDriver(new URL(URL2),capabilities);
    }

    @AfterMethod(alwaysRun=true)
    public void afterMethod(ITestResult result) throws Exception {		    	
    	ExtentReportsUtil.getExtentResult(result);
		Logger.log("Results Retrieved");
    }
    
    @AfterTest
    public void tearDown() {  
    	System.out.println(failTC);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
    	try {
			if (failTC == 0) {
				System.out.println("Setting session status to Passed");
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\"}}");
			}
			else {
				System.out.println("Setting session status to Failed");
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\"}}");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	driver.quit();
    	Logger.log("End Test");
    }
    
    @AfterSuite
	public void endTest() {
		ExtentReportsUtil.flushExtentReport();
		ExtentReportsUtil.closeExtentReport();
		Logger.log("End Report");
	}
    
}
