package com.live.magento.test_area;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.live.magento.pages.AbstractPage;
import com.live.magento.pages.HomePage;
import com.live.magento.pages.MyAccountPage;
import com.live.magento.pages.SearchResultPage;
import com.live.magento.pages.WelcomePage;
import com.live.magento.utilities.Screenshot;
import com.live.magento.utilities.UrlFormatter;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


@RunWith(DataProviderRunner.class)
public class liveTest {
	
	private WebDriver driver;
	private AbstractPage abstractPage;
	private HomePage homePage;
	private MyAccountPage myAccountPage;
	private WelcomePage welcomePage;
	private SearchResultPage searchResultPage;
	



@Before
public void setUp(){
	driver = new FirefoxDriver();
	abstractPage = new AbstractPage(driver);
	homePage = new HomePage(driver);
	myAccountPage = new MyAccountPage(driver);
	welcomePage = new WelcomePage(driver);		
	searchResultPage = new SearchResultPage(driver);
	
	abstractPage.openAndMaximizeBrowser();

}	


@Test @Ignore
public void testLoginFunctionality(){

	homePage.openMyAccount();
	//myAccountPage.loginWith();
	welcomePage.verifyLogin();
	}


@Test  @UseDataProvider("dataForSearchProduct")
public void searchingForProducts(String productName){
	abstractPage.searchForProduct(productName);
	searchResultPage.verifyProduct(productName);
}


@DataProvider
public static Object[][]dataForSearchProduct(){
	return new Object[][]{
		{"LG LCD"},
		{"Samsung Galaxy"},
		{"IPhone"}
	};
}

@After
public void closeBrowser(){
	abstractPage.tearDownBrowser();
}

}