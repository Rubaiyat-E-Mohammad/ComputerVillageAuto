package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserAccountManagement {
	
	WebDriver driver;
	
	public UserAccountManagement(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean editProfile(String firstname, String lastname, String telephone) {
		
		driver.findElement(By.className("edit-info")).click();
		
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[2]/div[2]/button/span")).click();
		WebElement successMessage = driver.findElement(By.className("alert-success"));
        return successMessage.isDisplayed();
		
	}
	
	public boolean changePassword(String password) {
		
		driver.findElement(By.className("edit-pass")).click();
		
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/button/span")).click();
		WebElement successMessage = driver.findElement(By.className("alert-success"));
        return successMessage.isDisplayed();
	}
	
	public boolean address(String firstname, String lastname, String address, String city) {
		
		driver.findElement(By.className("edit-address")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/a")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.name("address_1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		
		WebElement country = driver.findElement(By.id("input-country"));
		Select dropDown = new Select(country);
		dropDown.selectByVisibleText("Bangladesh");
		
		WebElement region = driver.findElement(By.id("input-zone"));
		Select zone = new Select(region);
		zone.selectByVisibleText("Chittagong");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[2]/div[2]/button/span")).click();
		
		WebElement successMessage = driver.findElement(By.className("alert-success"));
        return successMessage.isDisplayed();
		
		
	}
	
	public void orderHistory() {
		
		driver.findElement(By.className("top-menu-item-5")).click();
		driver.findElement(By.className("edit-order")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
	}
	
	public void transaction() {
		
		driver.findElement(By.className("edit-transactions")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/a")).click();
	}
	

}
