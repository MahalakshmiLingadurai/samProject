package other;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pak.ElementUtil;

public class SVGElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		ElementUtil eu = new ElementUtil(driver);
		 By textBox= By.xpath("//input[@id='Form_submitForm_subdomain111']");
	eu.customWait(10, textBox).sendKeys("maha");
		
		


	}

}
