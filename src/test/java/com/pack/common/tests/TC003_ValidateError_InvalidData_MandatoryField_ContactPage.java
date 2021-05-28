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




public class TC003_ValidateError_InvalidData_MandatoryField_ContactPage extends TestBaseSetup {

	WebDriver driver;
	ExtentReports reporter;
	String forname_value;
	String email_value;
	String message_value;
	String url = Property.getProperty("url");
	String forename = Property.getProperty("forename_invalid");
	String surname = Property.getProperty("surname_invalid");
	String email = Property.getProperty("email_invalid");
	String telephone = Property.getProperty("telephone_invalid");
	String Message = Property.getProperty("message_invalid");
	ContactPage contact_page = new ContactPage();
	ExtentTest logger;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}


	@Test(dataProvider = "createreport", dataProviderClass = StaticProvider.class)
	public void ValidateError_InvalidData_MandatoryField_ContactPage(ExtentReports extentreporter) throws Exception {

		reporter = extentreporter;
		try {
			logger = reporter.startTest("TC003_ValidateError_InvalidData_MandatoryField_ContactPage");
			
			contact_page.clickContact(driver, logger);
			if (contact_page.validateContactPage(driver) == true) {
				contact_page.enterForename(driver, forename, logger);
				contact_page.enterSurname(driver, surname);
				contact_page.enterEmail(driver, email, logger);
				contact_page.enterTelephone(driver, telephone);
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


