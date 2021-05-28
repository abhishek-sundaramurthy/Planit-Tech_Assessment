package com.pack.common.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.ContactPage;
import com.pack.utilities.Property;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;




public class TC001_ValidateError_ContactPage extends TestBaseSetup {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports reporter;
	String forname_value;
	String email_value;
	String message_value;
	String url = Property.getProperty("url");
	String forename = Property.getProperty("forename");;
	String email = Property.getProperty("email");
	String Message = Property.getProperty("message");
	ContactPage contact_page = new ContactPage();
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test(dataProvider = "createreport", dataProviderClass = StaticProvider.class)
	public void ValidateError_ContactPage(ExtentReports extentreporter) throws Exception {

		reporter = extentreporter;
		try {
			logger = reporter.startTest("TC001_ValidateError_ContactPage");
			contact_page.clickContact(driver, logger);
			if (contact_page.validateContactPage(driver) == true) {
				contact_page.clickSubmit(driver, logger);
				forname_value = contact_page.getForenameValue(driver);
				email_value = contact_page.getEmailValue(driver);
				message_value = contact_page.getMessageValue(driver);
				contact_page.validateError(driver, forname_value, email_value, message_value, logger);
				contact_page.enterForename(driver, forename, logger);
				contact_page.enterEmail(driver, email, logger);
				contact_page.enterMessage(driver, Message, logger);
				contact_page.validateError(driver, forename, email, Message, logger);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		
		}

	}
	@AfterClass
	public void tearDown() {
		reporter.endTest(logger);
		reporter.flush();
	}

}
