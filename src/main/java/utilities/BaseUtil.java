package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtil {
	
	public static WebDriver driver; 
	
	/***
	 * this method is used to opens the browsers based on arguments passed while calling method  
	 * @param browsername
	 * @return
	 * Usage - launchBrowser("Chrome")
	 * @param - Chrome / IE / FireFox  
	 */
	
	
	public WebDriver launchBrowser (String browsername) {
		// opens the  browser based on argument passed
		if (browsername.equalsIgnoreCase("Chrome")) {   // opening chrome
			 WebDriverManager.chromedriver().setup();
		     driver =  new ChromeDriver();
		
		} else if  (browsername.equalsIgnoreCase("IE")) {  // opening IE
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
			WebDriverManager.iedriver().setup();
			 driver =  new InternetExplorerDriver(caps);  //  strike off is because we are using older version
			
		} else if  (browsername.equalsIgnoreCase("Firefox")) { // opening FireFox
			WebDriverManager.firefoxdriver().setup();
			 driver =  new FirefoxDriver();
			
		} else {
			System.out.println("Browser is not matching");
		}
		
		driver.manage().deleteAllCookies(); // To delete all the cookies
		
	    //Implicit wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		
		driver.manage().window().maximize(); 
		
		return driver;			
					
			
		
	}
	    // method overloading concept  -- > polymorphism  (compiletime polymorphism)
	
	
		// passing string -- >  selectByVisibleText / SelectByVal
	
	   /***
	    * To select the values from Drop Down based on element details passed and String value passed
	    * @param elemDetails
	    * @param value
	    */
	
	public void selectValueFromDropDown(WebElement elemDetails, String value) {
		Select s = new Select(elemDetails);
		s.selectByVisibleText(value);
	}
	
	    // passing int  -->  example - selectByIndex
	
	  /***
	   * To select the values from Drop Down based on element details passed and int value passed
	   * @param elemDetails
	   * @param value
	   */
     
	public void selectValueFromDropDown(WebElement elemDetails, int value) {
		Select s = new Select(elemDetails);
		s.selectByIndex(value);
    }
	
	
	public static void captureScreenShotsForPage(WebDriver driver, String fileName) {
		File srcFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/Screenshots/"+fileName+".png"));
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void captureScreenShotsOnElementBasis(WebElement element, String fileName) {
		File srcFile =  ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/Screenshots/"+fileName+".png"));
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
    }

}
