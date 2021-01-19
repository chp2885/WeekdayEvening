package seleniumConcepts;

import org.openqa.selenium.By;

import utilities.BaseUtil;

public class LoginTest extends BaseUtil {

	public static void main(String[] args) {
		//7. launching browser
		BaseUtil b = new BaseUtil();
		b.launchBrowser("Chrome");
		driver.get("https://www.surveymonkey.com/user/sign-in/?ut_source=homepage&ut_source3=megamenu");
		
		//8. creating reference for CommonUtils.java
		CommonUtils cu = new CommonUtils(driver);
		
		//9. Enter login credentials
//    	driver.findElement(By.id("username")).sendKeys("seleniumtraining1");
//		driver.findElement(By.id("password")).sendKeys("selenium1234");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		By userName = By.id("username");
		By password = By.id("password");
		By loginBtn = By.xpath("//button[@type='submit']");
		
//		cu.getElement(userName).sendKeys("seleniumtraining1");
//		cu.getElement(password).sendKeys("selenium1234");
//		cu.getElement(loginBtn).click();
		
		//13. 
		
		cu.enterValuesInInputFields(userName, "seleniumtraining1");
		cu.enterValuesInInputFields(password, "selenium1234");
		cu.performClick(loginBtn);
		
		
		
	
		

	}

}
