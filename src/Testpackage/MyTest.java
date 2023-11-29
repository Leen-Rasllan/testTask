package Testpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends prameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() {
		driver.get(url);

	}

	@Test()
	public void mytest() {

		WebElement userNameInput = driver.findElement(By.id("user-name"));

		WebElement passwordInput = driver.findElement(By.id("password"));

		WebElement loginButton = driver.findElement(By.id("login-button")); 

		userNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		

		List < WebElement >itemsNames = driver. findElements(By. className( "inventory_item_name") ) ;
		
		List<WebElement> itemsPrices = driver.findElements(By.className("inventory_item_price"));
		
		List<WebElement> myElements = driver.findElements(By.className("btn_primary"));
		
	//	List<WebElement> itemsNames = driver.findElements(By.className("your_item_name_class"));
		
	/*	for (int i =0; i < myELements. size ( ) ;i++) {
		
		myELements.get(i).click ();
		
		}
		
		for (int i = 0; i < itemsNames.size(); i++) {
		    String itemName = itemsNames.get(i).getText();
		    System.out.println(itemName);
		}*/
		
		
		
		
		for (int i = 0; i < myElements.size(); i++) {
		    String itemName = itemsNames.get(i).getText();

		    if (itemName.contains("Backpack") || itemName.contains("Fleece") || itemName.contains("Onesie")) {
		        System.out.println("This item " + itemName + " was not added, and the original price of this item is "
		                + itemsPrices.get(i).getText());
		        continue;
		    } else {
		        myElements.get(i).click();
		        System.out.println("This item " + itemName + " was added, and the price of this item is "
		                + itemsPrices.get(i).getText());
		    }
		}
		
		
		
		
		for (int i = 0; i < myElements.size(); i++) {
		    String itemName = itemsNames.get(i).getText();
		    String originalPrice = itemsPrices.get(i).getText();
		    double priceBeforeTax = Double.parseDouble(originalPrice.replace("$", ""));
		    double finalPrice = priceBeforeTax * 0.10;

		
		    if (Math.floor(finalPrice) % 2 == 0) {
		        System.out.println("The final price for " + itemName + " is an even number, and the value is: " + finalPrice);
		    } else {
		        System.out.println("The final price for " + itemName + " is an odd number, and the value is: " + finalPrice);
		    }


			
		}
		
		
		 Check.assertAll();


		 
		 
		 
		 
	}

	@AfterTest
	public void posttest() {
	}

}
