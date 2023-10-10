package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuildingPC {
	
	WebDriver driver;
	
	public BuildingPC(WebDriver driver) {
		this.driver = driver;
	}
	
	public void buildPC() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div[2]/div[3]/div[1]/div/ul/li[1]/a")).click();
		processor();
		motherboard();
		cpuCooler();
		ram();
		ssd();
		gpu();
		powerSupply();
		casing();
		driver.findElement(By.id("pc-builder-save")).click();
		
	}
	
	public void processor() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-1\"]/a")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[2]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void motherboard() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-2\"]/a")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[1]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void cpuCooler() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-5\"]/a")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[5]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void ram() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-6\"]/a")).click(); 
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//*[@id=\"filter-pc-builder-category\"]/div[3]/label/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"button-pc-builder-filter-desktop\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[1]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void ssd() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-7\"]/a")).click(); 
		
		driver.findElement(By.xpath("//*[@id=\"filter-pc-builder-category\"]/div[5]/label/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"button-pc-builder-filter-desktop\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[1]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void gpu() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-9\"]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"filter-pc-builder-category\"]/div[2]/label/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"button-pc-builder-filter-desktop\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[4]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void powerSupply() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-10\"]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"filter-pc-builder-category\"]/div[2]/label/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"button-pc-builder-filter-desktop\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[6]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}
	
	public void casing() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"pc-builder-component-choose-1-3\"]/a")).click();
		
		driver.findElement(By.xpath("(//div[@class='name'])[4]")).click();
		
		driver.findElement(By.id("button-cart")).click();
		
		Thread.sleep(1000);
	}

}
