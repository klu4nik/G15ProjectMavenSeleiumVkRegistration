package G15SavchukMaven.Vkregistration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import libs.WebElementsOnPage;
import static libs.ConfigData.getCfgValue;

public class RegistrationPage {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
		public RegistrationPage (WebDriver driver)
	{
		this.driver=driver;
		log=Logger.getLogger(getClass());
		webElementsOnPage = new WebElementsOnPage(driver);
	}
			
		/**
		 * Method closes url and Browser
		 */
		public void closeRegistrationPageAndBrowser() {
			webElementsOnPage.closeBrowserAndLink();;
		}
		
		/**
		 * Method open link from file config.properties
		 * @return
		 */
		public boolean openRegistrationPage() {
		webElementsOnPage.openBrowser();
		try {
			webElementsOnPage.openLink(getCfgValue("URL"));
			return true;
		} catch (Exception e) {
			log.error("Can't work with URL");
			return false;
			
			// TODO: handle exception
		}
				
		}
		
		public boolean typeTextInToInputFirstName(String firstName) {
			return webElementsOnPage.typeTextIntoInput("Joining.FirstName.input", firstName);
			
		}
		public boolean typeTextInToInputLastName(String lastName) {
			return webElementsOnPage.typeTextIntoInput("Joining.LastName.input", lastName);
			
		}
		
		
		
		public boolean selectValueFromDD(String valueFromTC) {
			return webElementsOnPage.selectValueFromDB("Joining.Dropdown", valueFromTC);
			}
		
		
		public boolean clickOnButtonSignUp(){
			return webElementsOnPage.clickButtonOrLink("Joining.Button");
		}
		
				
		public boolean checkValidationNotValidMessage() {
			return webElementsOnPage.isElementPresentOnPage("Joining.ErrorMessage");
			
		}
		
		public boolean checkValidationValidMessage() {
			return webElementsOnPage.isElementPresentOnPage("Joining.Header");
			
		}

	
}
