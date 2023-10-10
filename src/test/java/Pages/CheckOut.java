package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOut {

	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean checkoutProcess(String firstName, String address, String city) throws InterruptedException {
		
		try {
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/a")).click();
			
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			
			driver.findElement(By.name("address_1")).sendKeys(address);
			
			driver.findElement(By.name("city")).sendKeys(city);
			
			WebElement region = driver.findElement(By.id("input-payment-zone"));
			Select dropDown = new Select(region);
			dropDown.selectByVisibleText("Chittagong");
			driver.findElement(By.className("checkout-same-address")).click();
			
			driver.findElement(By.className("top-menu-item-5")).click();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
}
