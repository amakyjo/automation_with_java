package com.live.magento.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends AbstractPage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}

	public void verifyProduct(String productName) {
		try{
			logger.info("The verifyProduct method has been initiated");
			boolean searchRes = driver.getPageSource().contains(productName);
			Assert.assertTrue("The page does not contain " + productName, searchRes);
			logger.info("The product has been found on the page");
		}catch(Throwable t){
			logger.error("The verifyProduct method has encountered error" +t);
			camera.takeShot("verifyProduct");
		}
		
	}

}
