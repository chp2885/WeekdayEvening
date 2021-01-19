package seleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BaseUtil;

public class TC003_WorkingWithImages extends BaseUtil {

	public static void main(String[] args) {
		   BaseUtil bu = new BaseUtil();
		   bu.launchBrowser("Chrome");
		   
		   driver.get("https://www.ebay.com/");
		   
		   List<WebElement>images = driver.findElements(By.tagName("img"));
		   int totalImgesCount = images.size();
		   System.out.println("Total number of images on ebay application is :  " + totalImgesCount);
		   
		   for (int i = 0; i < images.size(); i++) {
			   
			String imgUrl =   images.get(i).getAttribute("src"); 
			System.out.println(imgUrl);
			
		}
	}
 
}
