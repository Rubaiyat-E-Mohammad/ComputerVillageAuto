package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	
	WebDriver driver;
	
	public ShoppingCart(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean viewItems() {
		
		driver.findElement(By.className("cart-heading")).click();
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div/table/tbody/tr/td[2]/a")).isDisplayed();
		
	}
	
	public boolean updateQuantity() {
		
		try {
			driver.findElement(By.className("fa-angle-up")).click();
			driver.findElement(By.className("fa-angle-up")).click();
			driver.findElement(By.className("fa-angle-up")).click();
			driver.findElement(By.className("fa-angle-down")).click();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	public boolean removeItems() throws InterruptedException {
		
		try {
			driver.findElement(By.className("btn-update")).click();
			driver.findElement(By.className("btn-remove")).click();
			driver.findElement(By.id("logo")).click();
			
			ProductSearch product = new ProductSearch(driver);
			String productName = "MacBook";
			product.search(productName);
			product.filters();
			
			ProductDetails add = new ProductDetails(driver);
			add.addToCart(productName);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
