package com.live.magento.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	private WebDriver driver;

	public Screenshot(WebDriver driver){
		this.driver = driver;
	}
	
	public void takeShot(String methodName){
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path1 = System.getProperty("user.dir");
		String path2 = "\\src\\main\\resources\\com\\live\\magento\\screenshots\\";
		try {
			FileUtils.copyFile(screenshot, new File(path1 + path2 + methodName + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
