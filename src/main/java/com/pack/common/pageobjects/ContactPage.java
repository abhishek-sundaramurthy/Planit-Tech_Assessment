package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ContactPage {

	// TODO Auto-generated method stub
	public void clickContact(WebDriver driver, ExtentTest logger) {
		try {
			driver.findElement(By.linkText("Contact")).click();
			logger.log(LogStatus.PASS, "Contact Link is Clicked");

		} catch (Exception e) {
		
			logger.log(LogStatus.FAIL, "Contact Link is not Clicked");
		}

	}

	public boolean validateContactPage(WebDriver driver) {
		String txt = driver.findElement(By.xpath("//*[@class='alert alert-info ng-scope']")).getText();
		if (txt.equals("We welcome your feedback - tell it how it is.")) {

			return true;
		} else {

			return false;
		}
	}

	public void clickSubmit(WebDriver driver, ExtentTest logger) {
		try {
			driver.findElement(By.linkText("Submit")).click();
			logger.log(LogStatus.PASS, "Submit Button is Clicked");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Submit Button is not Clicked");
		}

	}

	public String getMandatoryError(WebDriver driver) {
		String txt = driver.findElement(By.xpath("//*[@class='alert alert-error ng-scope']")).getText();
		return txt;
	}

	public boolean validateMandatoryError(WebDriver driver) {
		if (getMandatoryError(driver).contains("we won't get it unless you complete the form correctly")) {
			return true;
		}

		else {
			return false;
		}
	}

	public String getForenameValue(WebDriver driver) {
		String txt = driver.findElement(By.id("forename")).getText();

		return txt;
	}

	public String getEmailValue(WebDriver driver) {
		String txt = driver.findElement(By.id("email")).getText();
		return txt;
	}

	public String getMessageValue(WebDriver driver) {
		String txt = driver.findElement(By.id("message")).getText();
		return txt;
	}

	public String getForenameError(WebDriver driver) {
		String txt = driver.findElement(By.id("forename-err")).getText();
		return txt;
	}

	public boolean validateForenameError(WebDriver driver) {
		if (getForenameError(driver).equals("Forename is required")) {
			return true;
		}

		else {
			return false;
		}
	}

	public String getEmailError(WebDriver driver) {
		String txt = driver.findElement(By.id("email-err")).getText();
		return txt;
	}

	public boolean validateEmailError(WebDriver driver) {
		if (getEmailError(driver).equals("Email is required")) {
			return true;
		}

		else {
			return false;
		}
	}

	public String getMessageError(WebDriver driver) {
		String txt = driver.findElement(By.id("message-err")).getText();
		return txt;
	}

	public boolean validateMessageError(WebDriver driver) {
		if (getMessageError(driver).equals("Message is required")) {
			return true;
		}

		else {
			return false;
		}
	}

	public void enterForename(WebDriver driver, String forename, ExtentTest logger) {

		try {
			driver.findElement(By.id("forename")).sendKeys(forename);
			logger.log(LogStatus.INFO, "Forename value is entered");
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Forename value is not entered");
		}

	}

	public void enterEmail(WebDriver driver, String email, ExtentTest logger) {
		try {
			driver.findElement(By.id("email")).sendKeys(email);
			logger.log(LogStatus.INFO, "Email value is entered");
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Email value is not entered");
		}

	}

	public void enterMessage(WebDriver driver, String message, ExtentTest logger) {
		try {
			driver.findElement(By.id("message")).sendKeys(message);
			logger.log(LogStatus.INFO, "Message value is entered");
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Messgae is not entered");
		}

	}

	public String getSuccessMessage(WebDriver driver) {
		String txt = driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();
		return txt;
	}

	public boolean validateSuccessMessage(WebDriver driver, String forename) {
		if (getSuccessMessage(driver).equals("Thanks " + forename + ", we appreciate your feedback.")) {
			return true;
		}

		else {
			return false;
		}
	}

	public boolean isForeNameErrortPresent(WebDriver driver) {
		try {
			driver.findElement(By.id("forename-err"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isEmailErrortPresent(WebDriver driver) {
		try {
			driver.findElement(By.id("email-err"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMessageErrortPresent(WebDriver driver) {
		try {
			driver.findElement(By.id("message-err"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMandatoryErrortPresent(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//*[@class='alert alert-error ng-scope']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void validateError(WebDriver driver, String forname_value, String email_value, String message_value,
			ExtentTest logger) throws Exception {
		try {
			if (forname_value.equals("") && email_value.equals("") && message_value.equals("")) {
				Assert.assertTrue(validateForenameError(driver), "ForeName value is present");
				logger.log(LogStatus.PASS, "ForeName Error Messages is displayed and validated");
				Assert.assertTrue(validateEmailError(driver), "Email value is present");
				logger.log(LogStatus.PASS, "Email Error Messages is displayed and validated");
				Assert.assertTrue(validateMessageError(driver), "Message value is present");
				logger.log(LogStatus.PASS, "MessageBox Error Messages is displayed and validated");
				Assert.assertTrue(validateMandatoryError(driver), "Mandatory values are present");
				logger.log(LogStatus.PASS, "Mandatory Error Messages failure logs is displayed and validated");

				logger.log(LogStatus.PASS, "All Error Messages are displayed and validated");
			}
			if (!forname_value.equals("") && !email_value.equals("") && !message_value.equals("")) {
				if (isForeNameErrortPresent(driver) == false && isEmailErrortPresent(driver) == false
						&& isMessageErrortPresent(driver) == false && isMandatoryErrortPresent(driver) == false) {
					Assert.assertTrue(true, "All the Error Messages for Missing Mandatory Fields are displayed");
					System.out.println("done");
					logger.log(LogStatus.PASS, "No Error Messages are displayed after all mandatory values entered");
				}

				if (isEmailErrortPresent(driver) == true) {
					Assert.assertTrue(validateInvalidEmailError(driver), "Email Id value is valid");
					logger.log(LogStatus.PASS,
							"Error for email id populated when invalid data is entered and error message is validated");
				}

			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Error messgae is not validated as expected");
		}

	}

	private boolean validateInvalidEmailError(WebDriver driver) {
		if (getEmailError(driver).equals("Please enter a valid email")) {
			return true;
		}

		else {
			return false;
		}
	}

	public void validateFeedbackSuccessMessgae(WebDriver driver, String forename, ExtentTest logger) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-success']")));
			boolean status = element.isDisplayed();
			if (status) {
				System.out.println(driver.getCurrentUrl());
				Assert.assertTrue(validateSuccessMessage(driver, forename), "Feedback is not successfully submitted");
				logger.log(LogStatus.PASS, "Feedback submitted successfully");
			}
			
		} catch (Exception e) {
			e.getMessage();
			logger.log(LogStatus.FAIL, "Feedback not submitted successfully");
		}

	}

	public void enterSurname(WebDriver driver, String surname) {
		driver.findElement(By.id("surname")).sendKeys(surname);

	}

	public void enterTelephone(WebDriver driver, String telephone) {
		driver.findElement(By.id("telephone")).sendKeys(telephone);

	}

}
