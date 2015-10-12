package com.live.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	public void loginWith(String username, String password){
		try{
			logger.info("The loginWith method has started successfully");
			driver.findElement(By.id("email")).sendKeys(username);
			logger.info("username has been entered successfully");
			driver.findElement(By.id("pass")).sendKeys(password);
			logger.info("password has been entered successfully");
			driver.findElement(By.id("send2")).click();
			logger.info("my account has been clicked");
		}catch(Throwable t){
			logger.error("The method loginWith has encountered error" +t);
			camera.takeShot("loginWith");
		}

		
	}
}
