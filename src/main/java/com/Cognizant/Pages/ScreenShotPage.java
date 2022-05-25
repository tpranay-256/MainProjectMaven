package com.Cognizant.Pages;

//*******************To import all the required files*******************************//
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Cognizant.Bases.TestBase;

//***************************Creating class ******************************//
public class ScreenShotPage extends TestBase {

	//****************************** To create method for capturing the screen***********************************//
	public void screenShot() {
		
		/* Thread sleep Wait*/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* To capture the displayed screen */
		TakesScreenshot scrShot = (TakesScreenshot) driver;//type conversion
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); // yyyy-MM-dd
		String dateTime = sdf.format(date);
		String fileName = "screenshot_" + dateTime;

		File destFile = new File(System.getProperty("user.dir")+".\\src\\test\\resources\\Screenshot\\" + fileName + ".png");
		{
			try {
				FileUtils.copyFile(srcFile, destFile);//FileUtils.copyfile(Source ,destination)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
