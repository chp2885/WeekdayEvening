package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	//1. define WebDriver here
	WebDriver driver;
	
	//2. creating constructor
	public CommonUtils(WebDriver driver) {
		 //3. passing local variable to constructor class
		this.driver = driver;
		
	}
	
	//4. generic method for all WebElements
	// wrapper 
	// interview question -  did you use any wrapper ?  
    public WebElement getElement(By locator) {
    	//5. 
    	WebElement element = driver.findElement(locator);
    	//6. Returning element from the method to use it in someother place 
    	return element;
    	
    }
    
    //11. Method to click on a button
    //cu.getElement(loginBtn).click();    ---   create a wrapper method for this
    //driver.findElement(By.id("abc")).click();
    /**
     * This method can be used when we want to click on any button 
     * @param locator
     */
    public void performClick(By locator) {
    	try {
    		getElement(locator).click();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		System.out.println("Some exception occured while clicking on an element....");
    	}
    }
    
    //12. Enter values in inputField
    //cu.getElement(userName).sendKeys("seleniumtraining1");   -- create a wrapper method for this
    /**
     * This method used when we want to enter the values inside input field
     * @param locator
     * @param value
     */
    public void enterValuesInInputFields(By locator, String value) {
    	try {
    		getElement(locator).sendKeys(value);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		System.out.println("Some exception occured while entering values in input field....");
    	}
    }
    
// Interview question - what is your role in building a framework ?
    
// Answer- There was a commonUtil, I created a method to get an element, that element I called inside a method which
//       was created to get click on any element, where I passed the locator as argument so that I could click on it
//       I also put it inside try and catch block , so if the click is not happening It will throw an exception
    
    
}
