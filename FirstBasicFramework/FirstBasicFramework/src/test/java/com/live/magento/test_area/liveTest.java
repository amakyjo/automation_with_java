package com.live.magento.test_area;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.live.magento.pages.AbstractPage;
import com.live.magento.pages.HomePage;
import com.live.magento.pages.MyAccountPage;
import com.live.magento.pages.WelcomePage;
import com.live.magento.utilities.Screenshot;
import com.live.magento.utilities.UrlFormatter;



public class liveTest {
	
	private WebDriver driver;
	private AbstractPage abstractPage;
	private HomePage homePage;
	private MyAccountPage myAccountPage;
	private WelcomePage welcomePage;
	



@Before
public void setUp(){
	driver = new FirefoxDriver();
	abstractPage = new AbstractPage(driver);
	homePage = new HomePage(driver);
	myAccountPage = new MyAccountPage(driver);
	welcomePage = new WelcomePage(driver);	
	
	//abstractPage.loadFile();
}	


	
//
@Test
public void testLoginFunctionality(){
	abstractPage.openAndMaximizeBrowser();
	
	homePage.openMyAccount();
	myAccountPage.loginWith();
	welcomePage.verifyLogin();
	}

@After
public void closeBrowser(){
	abstractPage.tearDownBrowser();
}
}
