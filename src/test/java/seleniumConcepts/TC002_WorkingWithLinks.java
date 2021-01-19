package seleniumConcepts;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BaseUtil;

public class TC002_WorkingWithLinks extends BaseUtil {  

	public static void main(String[] args) {
		BaseUtil b = new BaseUtil();
		b.launchBrowser("Chrome"); 
		
		driver.get("https://www.facebook.com/");
		
		
		// clicking on a link 
	    /*driver.findElement(By.linkText("Forgotten password?")).click();*/
	    
	    String abc = driver.findElement(By.linkText("Forgotten password?")).getText();
	    System.out.println(abc.isEmpty());
		
/*	    // count number of links 
	    List<WebElement> links =  driver.findElements(By.tagName("a"));  //  check here -  please confirm 
	    System.out.println(links.size());
	    
	    // print all the link names 
	    
	    for (int i = 0; i < links.size(); i++) {
			  String linkname =  links.get(i).getText();
			  System.out.println(linkname);
		}*/

	}

}
