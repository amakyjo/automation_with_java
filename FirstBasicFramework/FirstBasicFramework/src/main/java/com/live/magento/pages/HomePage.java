package com.live.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openMyAccount(){
		try{
			logger.info("The openMyAccount method has started successfully");
			driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();
			logger.info("Account has been opened successfully");
		}catch(Throwable t){
			logger.error("The method openMyAccount has encountered error" +t);
			camera.takeShot("openMyAccount");
		}
	
	}
}
