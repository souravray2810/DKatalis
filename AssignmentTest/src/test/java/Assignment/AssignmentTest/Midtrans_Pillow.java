package Assignment.AssignmentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Midtrans_Pillow {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/rajbalani/git/DKatalis/AssignmentTest/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.midtrans.com/");
		System.out.println("Welcome to Midtrans..!");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[2]/div/div/a")).click();
		driver.findElement(By.className("cart-checkout")).click();
		System.out.println("Successfully added pillow to cart");
	}

}
