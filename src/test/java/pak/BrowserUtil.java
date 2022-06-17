package pak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

public WebDriver driver;
	
	public WebDriver launchbrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Ie"))
		{
			WebDriverManager.iedriver().setup();
			driver =new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		return driver;
		
	}
	public void launchURL(String url)
	{
		driver.get(url);
	}
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}
