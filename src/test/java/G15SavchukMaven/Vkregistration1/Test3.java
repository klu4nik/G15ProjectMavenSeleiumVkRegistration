package G15SavchukMaven.Vkregistration1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import libs.ConfigData;



import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import G15SavchukMaven.Vkregistration.RegistrationPage;

public class Test3 {
	WebDriver driver = new FirefoxDriver();
	RegistrationPage registrationPage = new RegistrationPage(driver);
	
	@Test
	public void Test3() {
	Assert.assertTrue("Some step is fail", 
		registrationPage.openRegistrationPage() &
		registrationPage.typeTextInToInputFirstName("11111111111")&
		registrationPage.selectValueFromDD("Joining.Dropdown.Male")&
		registrationPage.clickOnButtonSignUp());
		Assert.assertTrue("Acceptance criterion is not met ", registrationPage.checkValidationNotValidMessage());
}
@ After
public void tearDown(){
registrationPage.closeRegistrationPageAndBrowser();

}
}
