
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Chrome_B {

	WebDriver driver = null;

	//  SUCCESS_SCENARIO

	@Test(priority =1)
	@Given("Chrome Browser is open")
	public void C_browser_is_open() {		

		System.out.println("Starting Successcase Scenario");
		String prjpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", prjpath+"\\src\\test\\resources\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
		System.out.println("Chrome Browser Strated");

	}
	@Test(priority =2)
	@And("User is on Homepage in Chrome Browser")
	public void C_user_is_on_homepage() {		
		driver.get("https://demo.midtrans.com/");
	}
	@Test(priority =3)
	@When("User clicks on BuyNow in Chrome Browser")
	public void C_user_clicks_on_buy_now() {		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[2]/div/div[1]/a")).click();
		System.out.println("User clicked on BuyNow button");
	}
	@Test(priority =4)
	@Then("Shopping Cart section should be displayed in Chrome Browser")
	public void C_shopping_cart_section_should_be_displayed() {	
		String s = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div[1]/div[1]/span[1]")).getText();
		System.out.println("User navigated to " + s + "screen");
	}
	@Test(priority =5)
	@When("User clicks on Checkout in Chrome Browser")
	public void C_user_clicks_on_checkout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("cart-checkout")).click();
		System.out.println("User clicked on Checkout button");
	}
	@Test(priority =6)
	@Then("Order Summary pop up should be disaplyed in Chrome Browser")
	public void C_order_summary_pop_up_should_be_disaplyed()   { 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("snap-midtrans");

	}
	@Test(priority =7)
	@And("User clicks on Continue in Chrome Browser")
	public void C_user_clicks_on_continue() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.className("button-main-content")).click();
		System.out.println("User clicked on Continue button");
	}
	@Test(priority =8)
	@And("User clicks on Credit-Debit Card in Chrome Browser")
	public void C_user_clicks_on_credit_debit_card() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/credit-card']")).click();
	}
	@Test(priority =9)
	@And("User enters Card Nummber, Exp Date & CVV in Chrome Browser")
	public void C_user_enters_card_nummber_exp_date_cvv() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("cardnumber")).sendKeys("4811111111111114");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("1224");;  
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='']")).sendKeys("123");
		System.out.println("User entered all Payment details");
	}
	@Test(priority =10)
	@When("Hits on Pay Now in Chrome Browser")
	public void C_hits_on_pay_now() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/']")).click();
		System.out.println("User clicked on Pay Now button");
	}
	@Test(priority =11)
	@And("Users enters the Password in Chrome Browser")
	public void C_users_enters_the_password() throws InterruptedException {
		Thread.sleep(8000);
		WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
		driver.switchTo().frame(iframe);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("PaRes")));
		driver.findElement(By.name("PaRes")).sendKeys("112233");
	}
	@Test(priority =12)
	@When("Hits on OK in Chrome Browser")
	public void C_hits_on_ok() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("ok")).click();
		System.out.println("User entered all Password and clicked OK");
	}
	@Test(priority =13)
	@Then("Order is confirmed in Chrome Browser")
	public void C_order_is_confirmed() throws InterruptedException  {
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		String t = "Thank you for your purchase.";
		if ( driver.getPageSource().contains("Thank you for your purchase.")){
			System.out.println(t);
		} else {
			System.out.println("" + t + " text is Absent. ");
		}
		driver.close();
	}

	// FAIL_SCENARIO

	@Test(priority =14)
	@Given("Chrome Browser is open again")
	public void C1_browser_is_open_again() {		

		System.out.println("Starting Failcase Scenario");
		String prjpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", prjpath+"\\src\\test\\resources\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
		System.out.println("Chrome Browser Strated");

	}
	@Test(priority =15)
	@And("User is on Homepage in Chrome Browser failcase")
	public void C1_user_is_on_homepage() throws InterruptedException {	
		Thread.sleep(5000);
		driver.get("https://demo.midtrans.com/");
	}
	@Test(priority =16)
	@When("User clicks on BuyNow in Chrome Browser failcase")
	public void C1_user_clicks_on_buy_now_failcase() {	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[2]/div/div[1]/a")).click();
		System.out.println("User clicked on BuyNow button");
	}
	@Test(priority =17)
	@Then("Shopping Cart section should be displayed in Chrome Browser failcase")
	public void C1_shopping_cart_section_should_be_displayed() {	
		String s = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div[1]/div[1]/span[1]")).getText();
		System.out.println("User navigated to " + s + "screen");
	}
	@Test(priority =18)
	@When("User clicks on Checkout in Chrome Browser failcase")
	public void C1_user_clicks_on_checkout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("cart-checkout")).click();
		System.out.println("User clicked on Checkout button");
	}
	@Test(priority =19)
	@Then("Order Summary pop up should be disaplyed in Chrome Browser failcase")
	public void C1_order_summary_pop_up_should_be_disaplyed()   { 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("snap-midtrans");
	}
	@Test(priority =20)
	@And("User clicks on Continue in Chrome Browser failcase")
	public void C1_user_clicks_on_continue() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.className("button-main-content")).click();
		System.out.println("User clicked on Continue button");
	}
	@Test(priority =21)
	@And("User clicks on Credit-Debit Card in Chrome Browser failcase")
	public void C1_user_clicks_on_credit_debit_card() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/credit-card']")).click();
	}
	@Test(priority =22)
	@And("User enters Card Nummber, Exp Date & CVV in Chrome Browser failcase")
	public void C1_user_enters_card_nummber_exp_date_cvv() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("cardnumber")).sendKeys("4911111111111113");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("1224");;  
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='']")).sendKeys("123");
		System.out.println("User entered all Payment details");
	}
	@Test(priority =23)
	@When("Hits on Pay Now in Chrome Browser failcase")
	public void C1_hits_on_pay_now() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/']")).click();
		System.out.println("User clicked on Pay Now button");
	}
	@Test(priority =24)
	@And("Users enters the Password in Chrome Browser failcase")
	public void C1_users_enters_the_password() throws InterruptedException {
		Thread.sleep(8000);
		WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
		driver.switchTo().frame(iframe);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("PaRes")));
		driver.findElement(By.name("PaRes")).sendKeys("112233");
	}
	@Test(priority =25)
	@When("Hits on OK in Chrome Browser failcase")
	public void C1_hits_on_ok() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("ok")).click();
		System.out.println("User entered all Password and clicked OK");
	}
	@Test(priority =26)
	@Then("Transaction failed in Chrome Browser")
	public void C1_transaction_fail() throws InterruptedException  {
		Thread.sleep(8000);
		driver.switchTo().frame("snap-midtrans");
		String t = driver.findElement(By.xpath("//*[@id=\"application\"]/div[3]/div/div/div/div/div/div[1]/span")).getText(); 
		System.out.println(t);
		driver.close();
		driver.quit();
	}
}
