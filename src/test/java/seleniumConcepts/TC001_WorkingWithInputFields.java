package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import utilities.BaseUtil;

public class TC001_WorkingWithInputFields extends BaseUtil {

	public static void main(String[] args) throws InterruptedException {
		
		BaseUtil bu = new BaseUtil();
		bu.launchBrowser("Chrome");
		
		//1. Entering values inside input fields
		
		driver.get("https://www.surveymonkey.com/user/sign-in/?ut_source=homepage&ut_source3=megamenu");
		/*driver.findElement(By.id("username")).sendKeys("NameTraining");
		driver.findElement(By.id("password")).sendKeys("PassTraining");*/
		
		//2. Clear the values that are entered
		
		/*driver.findElement(By.id("username")).sendKeys("NameTraining");
		Thread.sleep(3000);
		driver.findElement(By.id("username")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("NewName"); */
		
		WebElement userName = driver.findElement(By.id("username"));
		
		userName.sendKeys("NameTraining");
		Thread.sleep(2000);
		userName.clear();
		Thread.sleep(2000); 
		userName.sendKeys("NewName"); 
		
		
		
		// 3. Capture the value that is entered in input field  
		
		String userNameVal = userName.getAttribute("value");
		System.out.println("Value entered in username field is :" + userNameVal);
		
		// verify that username is entered
		
		/*if (userNameVal.equalsIgnoreCase("NewName")) {*/
		if (userNameVal != null) {
			System.out.println("Pass");
		}

	     else { System.out.println("Fail");

        }
	}
}
