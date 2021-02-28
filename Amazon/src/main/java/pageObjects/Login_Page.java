package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Page {
	
	static WebDriver driver = null;
	
	//
	
	@Test
	public static void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement signMenuOption = driver.findElement(By.id("nav-link-accountList"));
		action.moveToElement(signMenuOption).click().perform();
		driver.findElement(By.id("ap_email")).sendKeys("pesaru.vinay07@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
		driver.findElement(By.id("signInSubmit")).click();
		WebElement txtBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		txtBox.sendKeys("qa testing for beginners");
		
		//a-size-medium a-color-price header-price a-text-normal
		driver.findElement(By.id("nav-search-submit-button")).submit();
		Thread.sleep(2000);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0]", txtBox);
		driver.findElement(By.xpath("//div[@data-component-type='s-search-result' and @data-cel-widget='search_result_1']")).click();
		String price = driver.findElement(By.id("newBuyBoxPrice")).getText();
		System.out.println("PRICE=====>" +price);
		driver.findElement(By.id("add-to-cart-button")).click();
		String cartPrice = driver.findElement(By.xpath("//div[@id='hlb-subcart']/child::div[1]//span[2]")).getText();
		System.out.println("PRICE=====>" +cartPrice);
		
		driver.findElement(By.id("hlb-ptc-btn-native")).click();
		
	}
	
	


}
