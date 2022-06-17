package pak;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver= bu.launchbrowser("chrome");
		bu.launchURL("https://demo.opencart.com/index.php?route=account/login");
		bu.maximizeBrowser();
		ElementUtil eu = new ElementUtil(driver);
		By registerLink=By.xpath("(//a[text()='Registerrrrr'])[2]");
		
		
		//Fluent Wait
		
		Wait<WebDriver> w=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("Element is not found");
		
		w.until(ExpectedConditions.presenceOfElementLocated(registerLink));
	
				
		
	
		
	
		
		
		
	
				
		

	}

}

