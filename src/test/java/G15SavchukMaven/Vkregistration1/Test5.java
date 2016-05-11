package G15SavchukMaven.Vkregistration1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import G15SavchukMaven.Vkregistration.RegistrationPage;

public class Test5 {
	WebDriver driver = new FirefoxDriver();
	RegistrationPage registrationPage = new RegistrationPage(driver);
	
	@Test
	public void Test5() {
	Assert.assertTrue("Some step is fail", registrationPage.openRegistrationPage() &registrationPage.clickOnButtonSignUp());
		Assert.assertTrue("Acceptance criterion is not met ",  registrationPage.checkValidationNotValidMessage());
}
@ After
public void tearDown(){
registrationPage.closeRegistrationPageAndBrowser();

}

}
