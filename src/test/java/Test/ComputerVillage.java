package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import Pages.BuildingPC;
import Pages.CheckOut;
import Pages.ProductDetails;
import Pages.ProductSearch;
import Pages.ShoppingCart;
import Pages.UserAccountManagement;
import Pages.UserAuthentication;

@Epic("ComputerVillage Tests")
public class ComputerVillage {
	
	
	WebDriver driver;
	
	@BeforeTest
	@Description("Setting up the base URL")
	public void setBaseUrl() throws InterruptedException {
	    try {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.computervillage.com.bd/");
	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Failed to set up the base URL and WebDriver: " + e.getMessage());
	    }
		
	}
	
	
	@Test(priority = 1, description = "Verify that a user cannot log in with invalid credentials.")
    @Severity(SeverityLevel.NORMAL)
	public void invalidCredential() throws InterruptedException {
		UserAuthentication user = new UserAuthentication(driver);
		user.invalidCredentials("tonmon6@gmail.com", "null");
		Assert.assertTrue(user.isErrorMessageDisplayed(), "Error message not displayed for invalid credentials");
	}
	
	@Test(priority = 2, description = "Verify that a user can successfully register his account")
    @Severity(SeverityLevel.CRITICAL)
	public void signup() throws InterruptedException {
		UserAuthentication user = new UserAuthentication(driver);
		user.signup("Ton","Rub","moyemoye1@gmail.com","01600000002","tonmon1234");
		Assert.assertTrue(user.isSignupSuccessful(), "Signup was not successful");
		user.logout();
	}
	
	@Test(priority = 3, description = "Verify that a user can reset their password.")
    @Severity(SeverityLevel.CRITICAL)
	public void resetPassword() throws InterruptedException {
		UserAuthentication user = new UserAuthentication(driver);
		user.resetPassword("moyemoye@gmail.com");
		Assert.assertTrue(user.isResetPasswordSuccessful(), "Reset Password was not successful");
	}
	
	@Test(priority = 4, description = "Verify that a user can log in by valid credential")
	@Severity(SeverityLevel.CRITICAL)
	public void login() throws InterruptedException {
		UserAuthentication user = new UserAuthentication(driver);
		Assert.assertTrue(user.login("moyemoye1@gmail.com", "tonmon1234"), "Log in failed");
	}
	
	@Test(priority = 5, description = "Verify that a user can search for a product using the search bar.")
    @Severity(SeverityLevel.NORMAL)
	public void search() throws InterruptedException {
		ProductSearch product = new ProductSearch(driver);
		String productName = "MacBook";
		product.search(productName);
	}
	
	@Test(priority = 6, description = "Verify that search results are displayed correctly.")
    @Severity(SeverityLevel.NORMAL)
	public void results() throws InterruptedException {
		ProductSearch product = new ProductSearch(driver);
		String productName = "MacBook";
		Assert.assertTrue(product.results(productName), "Product does not exists");
	}
	
	@Test(priority = 7, description = "Verify that filters (processor, brand) work correctly on the search results page.")
    @Severity(SeverityLevel.NORMAL)
	public void filters() throws InterruptedException {
		ProductSearch product = new ProductSearch(driver);
		Assert.assertTrue(product.filters(), "Filter not applied");
	}
	
	@Test(priority = 8, description = "Verify that a user can view the details of a product.")
    @Severity(SeverityLevel.NORMAL)
	public void productDetails() throws InterruptedException {
		ProductDetails product = new ProductDetails(driver);
		Assert.assertTrue(product.details(), "Product details not displayed");
	}
	
	@Test(priority = 9, description = "Verify that product reviews are displayed correctly.")
    @Severity(SeverityLevel.NORMAL)
	public void productReviews() throws InterruptedException {
		ProductDetails product = new ProductDetails(driver);
		Assert.assertTrue(product.reviews(), "Product reviews are not displayed");
	}
	
	@Test(priority = 10, description = "Verify that a user can add a product to the cart.")
    @Severity(SeverityLevel.NORMAL)
	public void addToCart() throws InterruptedException {
		ProductDetails product = new ProductDetails(driver);
		Assert.assertTrue(product.addToCart("MacBook"),"Product not added");
	}
	
	@Test(priority = 11, description = "Verify that a user can view the items in their shopping cart.")
    @Severity(SeverityLevel.NORMAL)
	public void viewCart() throws InterruptedException {
		
		ShoppingCart cart = new ShoppingCart(driver);
		Assert.assertTrue(cart.viewItems(), "Item not displayed");
	}
	
	@Test(priority = 12, description = "Verify that a user can update the quantity of items in the cart.")
    @Severity(SeverityLevel.CRITICAL)
	public void updateQuantity() throws InterruptedException {
		
		ShoppingCart cart = new ShoppingCart(driver);
		Assert.assertTrue(cart.updateQuantity(), "Quantity not updated");
	}
	
	@Test(priority = 13, description = "Verify that a user can remove items from the cart.")
    @Severity(SeverityLevel.CRITICAL)
	public void removeItems() throws InterruptedException {
		
		ShoppingCart cart = new ShoppingCart(driver);
		
		Assert.assertTrue(cart.removeItems(), "Item not removed");
	}
	
	@Test(priority = 14, description = "Verify that the checkout process includes the correct steps (name,address,contact).")
    @Severity(SeverityLevel.CRITICAL)
	public void checkOut() throws InterruptedException {
		
		CheckOut check = new CheckOut(driver);
		Assert.assertTrue(check.checkoutProcess("Ton","Saint Martin", "Cox's Bazar"));
		
	}
	
	@Test(priority = 15, description = "Verify that a user can update their profile information.")
    @Severity(SeverityLevel.CRITICAL)
	public void editProfile() throws InterruptedException {
		
		UserAccountManagement account = new UserAccountManagement(driver);
		
		Assert.assertTrue(account.editProfile("Tonu","Toni", "01700000001"));
	}
	
	@Test(priority = 16, description = "Verify that user can change their password")
    @Severity(SeverityLevel.CRITICAL)
	public void changePassword() throws InterruptedException {
		
		UserAccountManagement account = new UserAccountManagement(driver);
		
		Assert.assertTrue(account.changePassword("TTTTTttttt123"));
	}
	
	@Test(priority = 17, description = "Verify that a user can add address to the address book")
    @Severity(SeverityLevel.CRITICAL)
	public void addAddress() throws InterruptedException {
		
		UserAccountManagement account = new UserAccountManagement(driver);
		
		Assert.assertTrue(account.address("Ton","Rub","Shariatpur","Shariatpur"));
	}
	
	@Test(priority = 18, description = "Verify that a user can view their order history")
    @Severity(SeverityLevel.NORMAL)
	public void orderHistory() throws InterruptedException {
		
		UserAccountManagement account = new UserAccountManagement(driver);
		
		account.orderHistory();
	}
	
	@Test(priority = 19, description = "Verify that a user can view their transaction history")
    @Severity(SeverityLevel.NORMAL)
	public void transactionHistory() throws InterruptedException {
		
		UserAccountManagement account = new UserAccountManagement(driver);
		
		account.transaction();
	}
	
	@Test(priority = 20, description = "Verify that a user can build a CPU according to their requirements")
    @Severity(SeverityLevel.CRITICAL)
	public void buildingPC() throws InterruptedException {
		
		BuildingPC pc = new BuildingPC(driver);
		
		pc.buildPC();
	}
	
	@AfterTest
	@Description("Quitting the WebDriver")
	public void quit() {
	    if (driver != null) {
	        driver.quit();
	    }	
	}
	
}