package common;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.ExtentReportsUtil;

public class BaseMethods {
	protected AndroidDriver driver;
	protected WebDriverWait wait;
	
	public BaseMethods(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void navigateBack() {
		driver.navigate().back();
		System.out.println("Navigated to Previous page");
		ExtentReportsUtil.pass("Navigated to Previous page");
	}
	
	public void pressBackKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("Pressed Back Key");
		ExtentReportsUtil.pass("Pressed Back Key");
	}
	
	public void clickOnText(String value) {
		WebElement ele = driver.findElement(AppiumBy.xpath("//*[@text = '"+ value +"']"));
		try {
			ele.click();
			System.out.println("Clicked on text: " + value);
			ExtentReportsUtil.pass("Clicked on text: " + value);
		} catch (StaleElementReferenceException e) {
			ele = driver.findElement(AppiumBy.xpath("//*[text() = '"+ value +"']"));
			ele.click();
			System.out.println("Clicked on text: " + value);
			ExtentReportsUtil.pass("Clicked on text: " + value);
		}
	}
	
	public void clickElement(String[] element) {
		String locatorBy = element[0];
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				elm.click();
				System.out.println(element[1] + " was Clicked");
				ExtentReportsUtil.pass(element[1] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				elm.click();
				System.out.println(element[1] + " was Clicked");
				ExtentReportsUtil.pass(element[1] + " was Clicked");
			}	
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				elm.click();
				System.out.println(element[1] + " was Clicked");
				ExtentReportsUtil.pass(element[1] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				elm.click();
				System.out.println(element[1] + " was Clicked");
				ExtentReportsUtil.pass(element[1] + " was Clicked");
			}	
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				elm.click();
				System.out.println(element[1] + " was Clicked");
				ExtentReportsUtil.pass(element[1] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				elm.click();
				System.out.println(element[1] + " was Clicked");
				ExtentReportsUtil.pass(element[1] + " was Clicked");
			}	
		}
		
	}
	
	public void sendTextToElement(String[] element, String value) {
		String locatorBy = element[0];
		
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				elm.clear();
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[1]);	
				ExtentReportsUtil.pass("Send text value to element: " + element[1]);
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				elm.clear();
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[1]);
				ExtentReportsUtil.pass("Send text value to element: " + element[1]);
			}
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				elm.clear();
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[1]);
				ExtentReportsUtil.pass("Send text value to element: " + element[1]);
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				elm.clear();
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[1]);
				ExtentReportsUtil.pass("Send text value to element: " + element[1]);
			}

		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				elm.clear();
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[1]);
				ExtentReportsUtil.pass("Send text value to element: " + element[1]);
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				elm.clear();
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[1]);
				ExtentReportsUtil.pass("Send text value to element: " + element[1]);
			}
		}
	}
	
	public void validateIfCorrectText(String[] element, String expectedValue) {
		String locatorBy = element[0];
		String actualValue = null;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				actualValue = elm.getText();
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				actualValue = elm.getText();
			}
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				actualValue = elm.getText();
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				actualValue = elm.getText();
			}
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				actualValue = elm.getText();
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				actualValue = elm.getText();
			}
		}
		
		if (actualValue.contentEquals(expectedValue)) {
			System.out.println(element[1] + " value is equal to expected value");
			ExtentReportsUtil.pass(element[1] + " value is equal to expected value");	
		}
		else {
			System.out.println(element[1] + " value is NOT equal to expected value");
			ExtentReportsUtil.fail(element[1] + " value is NOT equal to expected value");
		}
		
		
	}
	
	public void longPressElement(String[] element) {
		String locatorBy = element[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
				ExtentReportsUtil.pass(element[1] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
				ExtentReportsUtil.pass(element[1] + " long pressed");
			}
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
				ExtentReportsUtil.pass(element[1] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
				ExtentReportsUtil.pass(element[1] + " long pressed");
			}
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
				ExtentReportsUtil.pass(element[1] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
				ExtentReportsUtil.pass(element[1] + " long pressed");
			}
		}
		
	}
	
	public void assertElementDisplayed(String[] element) {
		WebElement elm;
		boolean display = false;
		
		if (element[0] == "accessibilityId") {
			try {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				display = elm.isDisplayed();
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				display = elm.isDisplayed();
			}
			
		}
		else if (element[0] == "id") {
			try {
				elm = driver.findElement(AppiumBy.id(element[2]));
				display = elm.isDisplayed();
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				display = elm.isDisplayed();
			}
		}
		
		else if (element[0] == "xpath") {
			try {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				display = elm.isDisplayed();
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				display = elm.isDisplayed();
			}
		}
		
		if (display == true) {
			System.out.println(element[1] + " is displayed");
			ExtentReportsUtil.pass(element[1] + " is displayed");
		}
		else {
			System.out.println(element[1] + " is NOT displayed");
			ExtentReportsUtil.fail(element[1] + " is NOT displayed");
		}
	}
	
	public void assertElementNotDisplayed(String[] element) {
		boolean displayed = true;
		displayed = isDisplayed(element);
		if (displayed == false) {
			System.out.println(element[1] + " is not displayed");
			ExtentReportsUtil.pass(element[1] + " is not displayed");
		}
	}
	public boolean isDisplayed(String[] element) {
		try {
			if (element[0] == "accessibilityId") {
				driver.findElement(AppiumBy.accessibilityId(element[2]));
			}
			else if (element[0] == "id") {
				driver.findElement(AppiumBy.id(element[2]));
			}
			else if (element[0] == "xpath") {
				driver.findElement(AppiumBy.xpath(element[2]));
			}
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean scrollDownGesture() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("left", 100);
		params.put("top", 300);
		params.put("width", 1300);
		params.put("height", 2900);
		params.put("direction", "down");
		params.put("percent", 0.5);
		
		boolean canScrollMore = (Boolean) (js.executeScript("mobile: scrollGesture", params));
		
		return canScrollMore;
	}
	
	public void scrollToElementByUIAutomator(String[] element) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+element[2]+")"));
		System.out.println("Scrolled to: " + element[1]);
		ExtentReportsUtil.pass("Scrolled to: " + element[1]);
	}
	
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
		System.out.println("Scrolled to Text: " + text);
		ExtentReportsUtil.pass("Scrolled to Text: " + text);
	}
	
	public boolean flingGesture(String[] element) {
		String locatorBy = element[0];
		boolean canScrollMore = true;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("direction", "down");
			params.put("speed", 5000);
			canScrollMore = (Boolean) (js.executeScript("mobile: flingGesture", params));
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("direction", "down");
			params.put("speed", 5000);
			canScrollMore = (Boolean) (js.executeScript("mobile: flingGesture", params));
		}		
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("direction", "down");
			params.put("speed", 5000);
			canScrollMore = (Boolean) (js.executeScript("mobile: flingGesture", params));
		}
		
		return canScrollMore;
	}
	
	public void dragGesture(String[] element, int coordinateX, int coordinateY) {
		String locatorBy = element[0];
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("endX", coordinateX);
			params.put("endY", coordinateY);
			js.executeScript("mobile: dragGesture", params);
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("endX", coordinateX);
			params.put("endY", coordinateY);
			js.executeScript("mobile: dragGesture", params);
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("endX", coordinateX);
			params.put("endY", coordinateY);
			js.executeScript("mobile: dragGesture", params);
		}
	}
	
	public void getElementsTextByXpath(String locatorByXpath) {
		List<WebElement> elements = driver.findElements(By.xpath(locatorByXpath));
        
		for(WebElement element: elements){
		    System.out.println(element.getText());
		    ExtentReportsUtil.info(element.getText());
		}
	}
	
	public String getElementText(String element[]) {
		WebElement elm;
		String elmtext = null;
		try {
			elm = driver.findElement(AppiumBy.xpath(element[2]));
			elmtext = elm.getText();
		} catch (Exception e) {
			elm = driver.findElement(AppiumBy.xpath(element[2]));
			elmtext = elm.getText();
		}
		return elmtext;
	}
	
	public void moveToElement(String[] ele) {
		
		String locatorBy = ele[0];
		
		if (locatorBy == "accessibilityId") {
			WebElement element = driver.findElement(AppiumBy.accessibilityId(ele[2]));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
				System.out.println("Moved to element: " + ele[1]);
				ExtentReportsUtil.pass("Moved to element: " + ele[1]);
			} catch (StaleElementReferenceException e) {
				element = driver.findElement(AppiumBy.accessibilityId(ele[2]));
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
				System.out.println("Moved to element: " + ele[1]);
				ExtentReportsUtil.pass("Moved to element: " + ele[1]);
			}
		}
		else if (locatorBy == "id") {
			WebElement element = driver.findElement(AppiumBy.id(ele[2]));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
				System.out.println("Moved to element: " + ele[1]);
				ExtentReportsUtil.pass("Moved to element: " + ele[1]);
			} catch (StaleElementReferenceException e) {
				element = driver.findElement(AppiumBy.id(ele[2]));
				Actions action = new Actions(driver);
				action.moveToElement(element);
				System.out.println("Moved to element: " + ele[1]);
				ExtentReportsUtil.pass("Moved to element: " + ele[1]);
				action.perform();	
			}
		}
		else if (locatorBy == "xpath") {
			WebElement element = driver.findElement(AppiumBy.xpath(ele[2]));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
				System.out.println("Moved to element: " + ele[1]);
				ExtentReportsUtil.pass("Moved to element: " + ele[1]);
			} catch (StaleElementReferenceException e) {
				element = driver.findElement(AppiumBy.xpath(ele[2]));
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
				System.out.println("Moved to element: " + ele[1]);
				ExtentReportsUtil.pass("Moved to element: " + ele[1]);
			}
			
		}
				
	}
}
