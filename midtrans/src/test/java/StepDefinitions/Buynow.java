package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Buynow {

	WebDriver driver = null;

	@Given("Browser is open")
	public void browser_is_open() {		

		String prjpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", prjpath+"/src/test/resources/Browsers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout

	}

	@And("User is on Homepage")
	public void user_is_on_homepage() {		
		driver.get("https://demo.midtrans.com/");
	}

	@When("User clicks on BuyNow")
	public void user_clicks_on_buy_now() {		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[2]/div/div[1]/a")).click();

	}

	@Then("Shopping Cart section should be displayed")
	public void shopping_cart_section_should_be_displayed() {		
		if(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div[1]/div[1]/span[1]"))!= null){

			System.out.println("Shopping Cart Text is Present");

		}else{

			System.out.println("Shopping Cart Text is Absent");

		}
	}

	@When("User clicks on Checkout")
	public void user_clicks_on_checkout() {	    
		driver.findElement(By.className("cart-checkout")).click();
	}

	@Then("Order Summary pop up should be disaplyed")
	public void order_summary_pop_up_should_be_disaplyed()   { 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("snap-midtrans");
		if(driver.findElement(By.className("text-page-title-content"))!= null){

			System.out.println("Order Summary Text is Present");

		}else{

			System.out.println("Order Summary Text is Absent");

		}
	}

	@And("User clicks on Continue")
	public void user_clicks_on_continue() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("button-main-content")).click();
	}

	@And("User clicks on Credit-Debit Card")
	public void user_clicks_on_credit_debit_card() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/credit-card']")).click();
	}

	@And("User enters Card Nummber, Exp Date & CVV")
	public void user_enters_card_nummber_exp_date_cvv() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("cardnumber")).sendKeys("4811111111111114");
		//driver.findElement(By.name("input-group col-xs-7")).sendKeys(Keys.TAB);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("input-group col-xs-7")).sendKeys("1224");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("input-group col-xs-5")).sendKeys("123");
	}

	@When("Hits on Pay Now")
	public void hits_on_pay_now() {
		driver.findElement(By.xpath("//a[@href ='#/']")).click();
	}

	@And("Users enters the Password")
	public void users_enters_the_password() {
		
	}

	@When("Hits on OK")
	public void hits_on_ok() {
		
	}

	@Then("Order is confirmed")
	public void order_is_confirmed() {
		System.out.println("Inside Step - Order is confirmed");
	}
}
