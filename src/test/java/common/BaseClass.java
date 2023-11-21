package common;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ExtentReportsUtil;
import utils.Logger;

public class BaseClass {
	public AndroidDriver driver;
	public static ITestResult result;
    
    public static final String AUTOMATE_USERNAME = "vincealecserquen_PUL7Gx";
	public static final String AUTOMATE_ACCESS_KEY = "6Nakjv6gG8CQfeyCxTHW";
	
	public static final String URL = 
			"http://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static int failTC = 0;
	
	String userName = System.getenv("BROWSERSTACK_USERNAME");
	String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	String app = System.getenv("BROWSERSTACK_APP_ID");
	String URL2 = "http://" +  userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
	
    @BeforeSuite
	public void setupReport() {
		ExtentReportsUtil.startExtentReport("\\Reports\\Test.html");
	}  
    
    @BeforeTest(alwaysRun=true)
    public void setUpRunEnv() throws Exception {
    	//Browserstack Capabilities
    	MutableCapabilities capabilities = new UiAutomator2Options();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("appiumVersion", "2.0.1"); //2.0.1
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("deviceName", "Samsung Galaxy S21");
        capabilities.setCapability("os_Version", "12.0");
        capabilities.setCapability("Project", "Vince's BS iFinibo Automation");
//        capabilities.setCapability("build", "Vince's BSBuild iFinibo");
//        capabilities.setCapability("app", "bs://f80d14888f1cf7e503a7de6366ec985e13631d03");
        capabilities.setCapability("build", buildName);
        capabilities.setCapability("name", buildName + " - JAVA");
        capabilities.setCapability("app", app);
        System.out.println(URL);
		driver = new AndroidDriver(new URL(URL2),capabilities);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("browserstack_executor: {'action': 'setSessionName', 'arguments': {'name': 'iFinibo Automation'}}");
        
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
//			if (result.getStatus() == ITestResult.SUCCESS) {
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
