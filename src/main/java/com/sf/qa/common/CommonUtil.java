package com.sf.qa.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtil {

	public static String toTakeScreenshot(String fileName, WebDriver driver)
	{
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File newFile= new File("C:\\Users\\athan\\eclipse-workspace\\DemoPOMFramework\\src\\main\\screenshots\\"+fileName+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(file, newFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newFile.getPath();
	}
}

