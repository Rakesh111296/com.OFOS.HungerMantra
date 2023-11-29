package com.GenricUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This Class is for Webdriver Utilities
 * 
 * @author Raki
 *
 */
public class WebdriverUtilities {

	/**
	 * this method maximizes the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * this method is for minimizing the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait until page is loaded
	 * 
	 * @param driver
	 * @param sec
	 */
	public void implicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}

	/**
	 * This method wait until the element is clickable
	 * 
	 * @param Webelement
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void WaitUntilElementToBeClickable(WebDriver driver, int sec, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * To handle Drop down and selecting by index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}

	/**
	 * To handle Drop down and selecting by Value
	 * 
	 * @param element
	 * @param Value
	 */
	public void handleDropDown(WebElement element, String Value) {
		Select sc = new Select(element);
		sc.selectByValue(Value);
	}

	/**
	 * To handle Drop down and selecting by text
	 * 
	 * @param Text
	 * @param element
	 */
	public void handleDropDown(String Text, WebElement element) {
		Select sc = new Select(element);
		sc.selectByVisibleText(Text);
	}

	/**
	 * To drag the element from source to and drop it to the destined
	 * 
	 * @param driver
	 * @param src
	 * @param dst
	 */

	public void dragNDrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dst);
		a.perform();

	}

	/**
	 * Right Click on the Screen
	 * 
	 * @param driver
	 */

	public void doubleClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick();
		a.perform();
	}

	/**
	 * Double click on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element);
		a.perform();
	}

	/**
	 * Right on page
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick();
		a.perform();
	}

	/**
	 * Right click on an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element);
		a.perform();
	}
	
	/**
	 * Mouse Over to a particular Element
	 * @param driver
	 * @param element
	 */

	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	
	/**
	 * Press enter
	 * @param driver
	 */
	public void keyPress(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * Robot class Pressing Enter Key
	 * @throws AWTException
	 */
	public void keyPressEnter() throws AWTException {

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * Robot class relaseing the enter key
	 * @throws AWTException
	 */

	public void keyReleaseEnter() throws AWTException {

		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * Switch to the Frame using Index
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	
	/**
	 * Switch to the frame using Name or ID
	 * @param driver
	 * @param FrameNameOrID
	 */
	public void switchToFrame(WebDriver driver, String FrameNameOrID) {
		driver.switchTo().frame(FrameNameOrID);
	}

	/**
	 * Switch to the frame using Address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	/**
	 * Switch to the window using Name or ID
	 * @param driver
	 * @param NameOrID
	 */
	public void switchToWindow(WebDriver driver, String NameOrID) {
		driver.switchTo().window(NameOrID);
	}
	
	
	
	/**
	 * Accepting the PopUp
	 * @param driver
	 */

	public void acceptAlertPop (WebDriver driver) {

		driver.switchTo().alert().accept();

	}
	
	/**
	 * Cancelling the popup 
	 * @param driver
	 */
	public void cancelAlertPop (WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}
	
	/**
	 * getting the text from the PopUp
	 * @param driver
	 * @return
	 */
	public String  getTextFromAlertPop (WebDriver driver) {

	String Text = driver.switchTo().alert().getText();
	return Text;

	}
	
	/**
	 * disable chrome_popups
	 */
	public void disablePopupBlocking () {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
	}
	/**
	 * disable Chrome Notifications
	 */
	public void disableNotifications () {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}
	
	/**
	 * disable the Geolocation popup from chrome
	 */
	public void disableGeoLocation () {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-geolocation");
	}
	/**
	 * Scroll to the Element to view 
	 * @param driver
	 * @param element
	 */
	public void scrollBarByElement (WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * scroll down to the location 0,500
	 * @param driver
	 */
	public void scrollByWindows (WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,500)", "");
	}
	
	/**
	 * This Method will take Screenshot and stores the image
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public static void captureScreenShot (WebDriver driver, String screenshotName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".//ScreenShot/"+screenshotName+".png");
	FileUtils.copyFile(src, dest);
	
		
	}
	
	
	

}
