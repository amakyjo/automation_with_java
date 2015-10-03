package com.live.magento.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends AbstractPage{
	
	public WelcomePage(WebDriver driver) {
		super(driver);

	}
	
	public void verifyLogin(){
		try{
			logger.info("The verifyLogin method has started successfully");
			boolean result = driver.getPageSource().contains(config.getProperty("message"));
			Assert.assertTrue("Test failed because the page does not contain"+ config.getProperty("message"), result);
			logger.info("name has been verified");
		}catch(Throwable t){
			logger.error("The method verifyLogin has encountered error" +t);
			camera.takeShot("verifyLogin");
			
		}
	}
	
	


}
