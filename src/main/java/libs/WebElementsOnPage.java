package libs;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static libs.ConfigData.ui;

public class WebElementsOnPage {
	WebDriver driver;
	Logger log;
	WebDriverWait wait;
	
	public WebElementsOnPage(WebDriver externalDriver) {
		this.driver = externalDriver;
		log=Logger.getLogger(getClass());
		wait = new WebDriverWait(driver, 20);
			
	}
	public void openBrowser() {
		try {
			driver.manage().window().maximize();
			// wait for loading
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Browser can't be opened" + e);
		}
	}
	/**
	 * Method  opened the link
	 * @param url
	 * @return
	 */
	public boolean openLink (String url){
		try {
			driver.get(url);
			log.info("Url was open");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Url can't be  opened" + e );
			return false;
		}
	}
	/**
	 * Method close connection and browser
	 */
	public void closeBrowserAndLink() {
		driver.quit();
		log.info("Browser is closed");
	}
	/**
	 * Method find the input by locator and type text
	 * @param locatorFromUIMapping
	 * @param text
	 * @return
	 */
	public boolean typeTextIntoInput(String locatorFromUIMapping, String text) {
		try {
			WebElement tempInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ui(locatorFromUIMapping))));
			tempInput.clear();
			tempInput.sendKeys(text);
			log.info("Text is inputed");
			return true;
		} catch (Exception e) {
			log.error("Text can't be inputed" + e);
			return false;
			// TODO: handle exception
		}
		
	}
	/**
	 * Method click on links and buttons
	 * @param locatorFromUIMapping
	 * @return
	 */
	public boolean clickButtonOrLink(String locatorFromUIMapping) {
		try {
			WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(ui(locatorFromUIMapping)));
			button.click();
			log.info("Element is clicked");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Element can't be clicked");
			return false;
		}
		
	}
	/**
	 * Method selects values from drop-down
	 * @param locatorFromUIMapping
	 * @param value
	 * @return
	 */
	public boolean selectValueFromDB(String locatorFromUIMapping, String valueLocatorFromUIMapping) {
		try {
			WebElement dB = wait.until(ExpectedConditions.elementToBeClickable(ui(locatorFromUIMapping)));
			dB.click();
			
			dB = wait.until(ExpectedConditions.visibilityOfElementLocated(ui(valueLocatorFromUIMapping)));
			dB.click();
			clickButtonOrLink(valueLocatorFromUIMapping);
			log.info("Element is selected by value");
			return true;
			} catch (Exception e) {
			// TODO: handle exception
			log.error("Can't work with dropdown");
			return false;
		}
		
	}
	
	/**
	 * Method search element on page	
	 * @param locatorNameFromUIMapping
	 * @return
	 */
	public boolean isElementPresentOnPage(String locatorNameFromUIMapping) {
		By method = null;
		try {
			method = ui(locatorNameFromUIMapping);
			log.info("Element find on page ");
			
		} catch (Exception e) {
			log.error("Can not work  with element" + e);
			Assert.fail("Can not work with UIMapping");
			
			// TODO: handle exception
		}
		try {
			WebElement tempElement = wait.until(ExpectedConditions.visibilityOfElementLocated(method));
						return tempElement.isEnabled(); //&& tempElement.isDisplayed();
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
		
	}


