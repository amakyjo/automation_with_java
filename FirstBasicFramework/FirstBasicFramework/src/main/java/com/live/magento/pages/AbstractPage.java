package com.live.magento.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.live.magento.utilities.Screenshot;
import com.live.magento.utilities.SecondUrlFormatter;
import com.live.magento.utilities.UrlFormatter;

public class AbstractPage {
	
	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static InputStream fis;
	protected static Screenshot camera;
	protected static Logger logger = LogManager.getLogger("TestLogger");

	public AbstractPage(WebDriver driver){
		this.driver = driver;
		camera = new Screenshot(driver);
		try {
			fis = new FileInputStream("C:\\Automation\\Projects\\FirstBasicFramework\\FirstBasicFramework\\src\\main\\resources\\testData.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

//	public void loadFile(){
//		
//		try{
//			fis = new FileInputStream("C:\\Automation\\Projects\\FirstBasicFramework\\FirstBasicFramework\\src\\main\\resources\\testData.properties");
//			config.load(fis);
//			logger.info("Properties file has been successfully loaaded");
//		}
//		catch (Throwable t){
//			logger.error("Properties file has not been loaded successfully:" +t.getMessage());
//		}
		
//		if(config.getProperty("browser").equalsIgnoreCase("firefox")){
//			driver = new FirefoxDriver();
//			logger.info("Firefox has been initialised successfully");
//		}
//		else if(config.getProperty("browser").equalsIgnoreCase("chrome")){
//			//driver = new ChromeDriver();
//			logger.info("Chrome has been initialised successfully");
//		}
		
//}
		
		
	public void openAndMaximizeBrowser(){
		try{
			logger.info("The openAndMaximiseBrowser method is started correctly");	
			driver.manage().window().maximize();
			logger.info("Browser has been maximized");
			String formatedUrl = SecondUrlFormatter.formatUrl(config.getProperty("baseUrl2"));
			logger.info("The Url has been formatted correctly");
			driver.navigate().to(formatedUrl);
			logger.info("The Web address has been loaded successfully");
		}catch(Throwable t){
			logger.error("The openAndMaximizeBrowser Method has encountered error" +t);
			camera.takeShot("openAndMaximizeBrowser");
		}
	}
	
	public void tearDownBrowser(){
		try{
			logger.info("The tearDownBrowser method has been initiated");
			driver.quit();
			logger.info("Browser has now quit");
			driver = null;
			logger.info("Browser has no value anymore");
		}catch(Throwable t){
			logger.error("The tearDownBrowser method has encountered error" +t);
			camera.takeShot("tearDownBrowser");
		}
	}
}
