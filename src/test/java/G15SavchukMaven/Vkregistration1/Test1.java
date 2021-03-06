package G15SavchukMaven.Vkregistration1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import libs.ConfigData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import G15SavchukMaven.Vkregistration.RegistrationPage;

public class Test1 {
	WebDriver driver = new FirefoxDriver();
	RegistrationPage registrationPage = new RegistrationPage(driver);

	@Test
		public void Test1() {

			Assert.assertTrue("Some step is fail",
			registrationPage.openRegistrationPage() & registrationPage.typeTextInToInputFirstName("Andrey")
						& registrationPage.typeTextInToInputLastName("Savchuk")
						& registrationPage.selectValueFromDD("Joining.Dropdown.Male")
						& registrationPage.clickOnButtonSignUp());
			Assert.assertTrue("Acceptance criterion is not met ", registrationPage.checkValidationValidMessage());
			}

	@After
		public void tearDown() {
			registrationPage.closeRegistrationPageAndBrowser();
		}

}
