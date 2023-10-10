package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails {
	
	WebDriver driver;
	
	public ProductDetails(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean details() {
		
		driver.navigate().refresh();
		driver.findElement(By.className("tab-3")).click();
		WebElement detail = driver.findElement(By.className("block-description"));
		return detail.isDisplayed();
		
	}
	
	public boolean reviews() {
		
		try {
		driver.navigate().refresh();
		WebElement elem = driver.findElement(By.className("tab-7"));
		elem.click();
        return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
    
	public boolean addToCart(String product) throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.id("button-cart")).click();
		driver.navigate().refresh();
		driver.findElement(By.className("cart-heading")).click();
		WebElement prodname = driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div/table/tbody/tr/td[2]/a"));
		if(prodname.getText().contains(product)) {
			return true;
		}
		return false;
	}
}
