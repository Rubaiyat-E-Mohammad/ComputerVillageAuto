package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAuthentication {
	
	WebDriver driver;
	
	public UserAuthentication(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}
	
	public void invalidCredentials(String useremail, String password) {
		
		driver.findElement(By.className("top-menu-item-4")).click();
		driver.findElement(By.id("input-email")).sendKeys(useremail);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[3]/div/button")).click();
		
	}
	
    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(By.className("alert-danger"));
        return errorMessage.isDisplayed();
    }
	
	public void signup(String firstname, String lastname, String useremail, String telephone, String password) throws InterruptedException {
		
		driver.findElement(By.className("top-menu-item-4")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div/a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).sendKeys(useremail);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[2]/div/button")).click();
	}
	
    public boolean isSignupSuccessful() {
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        return successMessage.isDisplayed();
    }
    
	public void logout() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		WebElement elem = driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div[2]/div[3]/div[1]/div/ul/li[4]/div/ul/li[4]/a"));
		String link = elem.getAttribute("href");
		driver.get(link);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
	}
	
	public void resetPassword(String useremail) {
		driver.findElement(By.className("top-menu-item-4")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/div/a")).click();
		driver.findElement(By.id("input-email")).sendKeys(useremail);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/button/span")).click();
	}
	
    public boolean isResetPasswordSuccessful() {
        WebElement successMessage = driver.findElement(By.className("alert-success"));
        return successMessage.isDisplayed();
    }
	
	public boolean login(String useremail, String password) throws InterruptedException {
		driver.findElement(By.className("top-menu-item-4")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys(useremail);
		Thread.sleep(3000);
		driver.findElement(By.id("input-password")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[3]/div/button")).click();
		WebElement login = driver.findElement(By.className("top-menu-item-5"));
		return login.isDisplayed();
	}

}
