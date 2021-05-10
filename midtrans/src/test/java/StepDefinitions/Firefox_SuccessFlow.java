
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Firefox_SuccessFlow {

	WebDriver driver = null;

	
	@Given("Firefox Browser is open")
	public void F_browser_is_open() {		

		String prjpath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", prjpath+"/src/test/resources/Browsers/geckodriver");		
		//FirefoxOptions options = new FirefoxOptions();
		//options.setLegacy(true);		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout

	}

	@And("User is on Homepage in Firefox Browser")
	public void F_user_is_on_homepage() {		
		driver.get("https://demo.midtrans.com/");
	}

	@When("User clicks on BuyNow in Firefox Browser")
	public void F_user_clicks_on_buy_now() {		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[2]/div/div[1]/a")).click();

	}

	@Then("Shopping Cart section should be displayed in Firefox Browser")
	public void F_shopping_cart_section_should_be_displayed() {		
		if(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div[1]/div[1]/span[1]"))!= null){

			System.out.println("Shopping Cart Text is Present");

		}else{

			System.out.println("Shopping Cart Text is Absent");

		}
	}

	@When("User clicks on Checkout in Firefox Browser")
	public void F_user_clicks_on_checkout() {	    
		driver.findElement(By.className("cart-checkout")).click();
	}

	@Then("Order Summary pop up should be disaplyed in Firefox Browser")
	public void F_order_summary_pop_up_should_be_disaplyed()   { 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("snap-midtrans");
		if(driver.findElement(By.className("text-page-title-content"))!= null){

			System.out.println("Order Summary Text is Present");

		}else{

			System.out.println("Order Summary Text is Absent");

		}
	}

	@And("User clicks on Continue in Firefox Browser")
	public void F_user_clicks_on_continue() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.className("button-main-content")).click();
	}

	@And("User clicks on Credit-Debit Card in Firefox Browser")
	public void F_user_clicks_on_credit_debit_card() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/credit-card']")).click();
	}

	@And("User enters Card Nummber, Exp Date & CVV in Firefox Browser")
	public void F_user_enters_card_nummber_exp_date_cvv() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("cardnumber")).sendKeys("4811111111111114");
		//driver.findElement(By.name("input-group col-xs-7")).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("1224");;  
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='']")).sendKeys("123");
	}

	@When("Hits on Pay Now in Firefox Browser")
	public void F_hits_on_pay_now() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href ='#/']")).click();
	}

	@And("Users enters the Password in Firefox Browser")
	public void F_users_enters_the_password() throws InterruptedException {
		
		
		int size = driver.findElements(By.tagName("iframe")).size(); 
	    System.out.println("Total Frames :" + size);
	    Thread.sleep(8000);
	    WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
	    driver.switchTo().frame(iframe);
		
	    String t1 = "Issuing Bank";
	      if ( driver.getPageSource().contains("Issuing Bank")){
	         System.out.println("Text: " + t1 + " is present. ");
	      } else {
	         System.out.println("Text: " + t1 + " is not present. ");
	      }
	      
	    WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("PaRes")));
		driver.findElement(By.name("PaRes")).sendKeys("112233");
	}

	@When("Hits on OK in Firefox Browser")
	public void F_hits_on_ok() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("ok")).click();
	}

	@Then("Order is confirmed in Firefox Browser")
	public void F_order_is_confirmed() throws InterruptedException  {
		 Thread.sleep(8000);
		driver.switchTo().parentFrame();
		String t = "Thank you for your purchase.";
	      // getPageSource() to get page source
	      if ( driver.getPageSource().contains("Thank you for your purchase.")){
	         System.out.println("Text: " + t + " is present. ");
	      } else {
	         System.out.println("Text: " + t + " is not present. ");
	      }
	    driver.close();
	    driver.quit();
	}
}
