package com.pack.common.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.ShopPage;
import com.pack.utilities.Property;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TC004_ValidateCartItems_ShopPage extends TestBaseSetup {
	WebDriver driver;
	ExtentReports reporter;
	ExtentTest logger;
	String forname_value;
	String email_value;
	String message_value;
	String url = Property.getProperty("url");
	String forename = Property.getProperty("forename_invalid");
	String surname = Property.getProperty("surname_invalid");
	String email = Property.getProperty("email_invalid");
	String telephone = Property.getProperty("telephone_invalid");
	String Message = Property.getProperty("message_invalid");
	ArrayList<String> button = new ArrayList<String>();
	
	ShopPage shop_page = new ShopPage();
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	List<Integer> llist = new LinkedList<Integer>();
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test(dataProvider = "createreport", dataProviderClass = StaticProvider.class)
	public void ShopCart(ExtentReports extentreporter) throws Exception {
		reporter = extentreporter;

		try {
			logger = reporter.startTest("TestValidation4_ShopPage");
		
			shop_page.clickShop(driver, logger);
			if (shop_page.validateShopPage(driver) == true) {
				Thread.sleep(1000);
				String button_text = shop_page.clickFunnyCow(driver, logger);
				String button_text1 = shop_page.clickFunnyCow(driver, logger);
				String button_text2 = shop_page.clickFluffyBunny(driver, logger);
				button.add(button_text);
				button.add(button_text1);
				button.add(button_text2);
				int Chart_count_selected = button.size();
				System.out.println(Chart_count_selected);
				map = shop_page.getIndividualCount(button);
				shop_page.clickCart(driver, logger);
				llist = shop_page.validateItems(driver, map, logger);
				int Chart_count_shopCart = ShopPage.sum(llist);
				if (Chart_count_selected == Chart_count_shopCart) {
					logger.log(LogStatus.PASS, "Total number of Items selected and Added to the Cart are same");
					System.out.println("Total number of Items selected and Added to the Cart are same");
					Assert.assertTrue(true, "Total number of Items selected and Added to the Cart are not same");
				} else {
					logger.log(LogStatus.FAIL, "Total number of Items selected and Added to the Cart are not same");
				}

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


