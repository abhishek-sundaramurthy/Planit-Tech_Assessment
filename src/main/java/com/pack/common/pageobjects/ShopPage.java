package com.pack.common.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShopPage {
	public void clickShop(WebDriver driver, ExtentTest logger) {
		try {
			driver.findElement(By.linkText("Shop")).click();
			logger.log(LogStatus.PASS, "Funny Cow button is clicked");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Funny Cow button is clicked");
		}

	}

	public boolean validateShopPage(WebDriver driver) {
		String txt = driver.getCurrentUrl();
		if (txt.equals("https://jupiter.cloud.planittesting.com/#/shop")) {
			return true;
		} else {
			return false;
		}
	}

	public String clickFunnyCow(WebDriver driver, ExtentTest logger) {
		try {

			String button_text = null;
			List<WebElement> elemts = driver.findElements(By.xpath("//*[@class='product-title ng-binding']"));
			for (int i = 0; i <= elemts.size() - 1; i++) {
				if (elemts.get(i).getText().equals("Funny Cow")) {
					button_text = elemts.get(i).getText();
					int j = i + 1;
					String path = "(//*[@class='btn btn-success'])[" + j + "]";
					driver.findElement(By.xpath(path)).click();
					logger.log(LogStatus.PASS, "Funny Cow button is clicked");
				}
			}
			return button_text;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Funny Cow button is not clicked");
			return e.getMessage();

		}
	}

	public String clickFluffyBunny(WebDriver driver, ExtentTest logger) {
		try {
			String button_text = null;
			List<WebElement> elemts = driver.findElements(By.xpath("//*[@class='product-title ng-binding']"));
			for (int i = 0; i <= elemts.size() - 1; i++) {
				if (elemts.get(i).getText().equals("Fluffy Bunny")) {
					button_text = elemts.get(i).getText();
					int j = i + 1;
					String path = "(//*[@class='btn btn-success'])[" + j + "]";
					driver.findElement(By.xpath(path)).click();
					logger.log(LogStatus.PASS, "Fluffy Bunny button  clicked");
				}
			}
			return button_text;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Fluffy Bunny button is not clicked");
			return e.getMessage();
		}
	}

	public void clickCart(WebDriver driver, ExtentTest logger) {
		try {
			driver.findElement(By.partialLinkText("Cart (")).click();
			logger.log(LogStatus.PASS, "Cart Link is clicked");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Cart Link is clicked");
		}

	}

	public List<Integer> validateItems(WebDriver driver, HashMap map, ExtentTest logger) {
		List<Integer> llist = new LinkedList<Integer>();
		try {
			HashMap hm = new HashMap();
			Set set = map.entrySet();
			Iterator it = set.iterator();

			while (it.hasNext()) {
				Map.Entry me = (Map.Entry) it.next();
				WebElement tbl = driver.findElement(By.xpath("//*[@class='table table-striped cart-items']"));
				List<WebElement> rows = tbl.findElements(By.tagName("tr"));
				for (int i = 0; i < rows.size(); i++) {
					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					for (int j = 0; j < cols.size(); j++) {
						if (cols.get(j).getText().equals(me.getKey())) {
							String path = "//*[@class='table table-striped cart-items']/tbody/tr[" + i
									+ "]/td[3]/input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']";
							String quantity = driver.findElement(By.xpath(path)).getAttribute("value");
							System.out.println(quantity);
							int number = Integer.parseInt(quantity);
							if (me.getValue().equals(number)) {
								llist.add(number);
								String message = "Quantity of the " + me.getKey() + " is " + me.getValue() + ".";
								logger.log(LogStatus.PASS, message);
								System.out.println("Quantity of the " + me.getKey() + " is " + me.getValue());
								Assert.assertTrue(true, "Quantity of the " + me.getKey() + " is not same");
							}

						}

					}
				}
			}
			return llist;
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Validation Error");
			return llist;
		}
	}

	public static int sum(List<Integer> list) {
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}

	public HashMap<String, Integer> getIndividualCount(ArrayList<String> button) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String temp : button) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}
		return map;
	}

}
