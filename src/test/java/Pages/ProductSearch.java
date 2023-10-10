package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSearch {
	
	WebDriver driver;
	
	public ProductSearch(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void search(String product) {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(product);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.RETURN);
		
	}
	
	public boolean results(String product) {
		
		List<WebElement> suggestionElements = driver.findElements(By.className("name"));
        for (WebElement suggestion : suggestionElements) {
            String temp = suggestion.getText();
            if(temp.contains(product)) {
            	return true;
            }
        }
		return false;
	}
	
	public boolean filters() {
		
		try {
			WebElement input = driver.findElement(By.className("filter-price-max"));
			input.clear();
			input.sendKeys("150000");
			input.sendKeys(Keys.RETURN);
			driver.navigate().refresh();
			
			driver.findElement(By.xpath("(//input[@name='q'])[1]")).click();		
	        driver.navigate().refresh();
	        
	        driver.findElement(By.xpath("(//input[@name='f16'])[2]")).click();
	        driver.navigate().refresh();
	        
	        driver.findElement(By.className("reset-filter")).click();
	        driver.navigate().refresh();
	        
	        driver.findElement(By.xpath("(//div[@class='name'])[2]")).click();
	        return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	

}
