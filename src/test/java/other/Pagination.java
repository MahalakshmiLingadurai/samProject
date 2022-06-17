package other;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pak.ElementUtil;

public class Pagination {
	
	
	@DataProvider()
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"maha","mahi"},{"muthu","mahi"}
				};
	}
	
	@Test(dataProvider="getData")
	
		public  void sample(String us,String pass) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
By username= By.id("input-email");
By password=By.id("input-password");
ElementUtil eu = new ElementUtil(driver);
eu.doSendKeys(username, us);
eu.doSendKeys(password, pass);
Thread.sleep(5000);



	
		
		
		}
		
	}


