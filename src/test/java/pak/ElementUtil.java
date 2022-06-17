package pak;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public WebElement getElement(By locator ,int timeout)
	{
		return doPresenceOFElementLocated(locator ,timeout);
	}
	
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String getTiltle()
	{
		return driver.getTitle();
	}
	
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator , String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public void doSendKeys(By locator ,int timeout ,String value)
	{
		doPresenceOFElementLocated(locator,timeout).sendKeys(value);
	}
	
	public void doSendKeys(By locator ,int timeout,long intervalTime ,String value)
	{
		doPresenceOFElementLocated(locator,timeout,intervalTime).sendKeys(value);
	}
	
	public void doSendKeysVisibiltyOfElement(By locator ,int timeout,String value)
	{
		isElementVisible(locator,timeout).sendKeys(value);
	}
	
	public void doSendKeysVisibiltyOfElement(By locator ,int timeout,long intervalTime,String value)
	{
		isElementVisible(locator,timeout,intervalTime).sendKeys(value);
	}
	public boolean doIsDisplayed(By locator)
	{
		 return getElement(locator).isDisplayed();
	}
	
	public String getAttribute(By locator ,String value)
	{
		return getElement(locator).getAttribute(value);
	}
	
	
//***********************************************Links************************************************************************************************************//
	public void linksCount(By locator)
	{
		List<WebElement> links= getElements(locator);
		System.out.println("Links Count: "+links.size());
		
	}
	public void linksText(By locator)
	{
		List<String> s= new ArrayList<String>();
		List<WebElement> links= getElements(locator);
		for(int i=0;i<links.size();i++)
		{
			String text=links.get(i).getText();
			s.add(text);
		}
		System.out.println(s);
	}
	public void linksTextWithoutSpace(By locator)
	{
		List<String> s= new ArrayList<String>();
		List<WebElement> links= getElements(locator);
		for(int i=0;i<links.size();i++)
		{
			String text=links.get(i).getText();
			if(text.isEmpty())
			{
				
			}
			else
			{
			s.add(text);
			}
		}
		System.out.println(s);
	}
//***********************************************LinksEnd************************************************************************************************************//
//*************************************************TextBox********************************************************************************************************
	public void textBoxCount(By locator)
	{
		List<WebElement> textBox= getElements(locator);
		System.out.println("TextBox Count: "+textBox.size());
		
	}
//*************************************************Images********************************************************************************************************
	public void imageCount(By locator)
	{
		List<WebElement> imageCount= getElements(locator);
		System.out.println("Total image is:" + imageCount.size());
	}
	
	public void getImageURL(By locator ,String value)
	{
	
		List<WebElement>  ele=  getElements(locator);
		for(int i=0;i<ele.size();i++)
		{
			String text=ele.get(i).getAttribute(value);
			System.out.println(text);
			
		}
		
	
	}
//************************************************Frames******************************************************************************************
	
public void frameint(int value)
{
	driver.switchTo().frame(value);
}

public void frameString(String value)
{
	driver.switchTo().frame(value);
}

public void frameWebElement(By locator)
{
	driver.switchTo().frame(getElement(locator));
}


//***********************************Select Class*************************************************************************************************
	
	public void selectByindex(By loactor, int indexvalue)
	{
		
		Select s = new Select(getElement(loactor));
		s.selectByIndex(indexvalue);
	}
	
	public void selectByValue(By locator ,String value)
	{
		Select s = new Select(getElement(locator));
		s.selectByValue(value);
		
	}
	public void selectByVisibleText(By locator ,String value)
	{
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(value);
		
	}
	public void deSelectByValue(By locator ,String value)
	{
		Select s = new Select(getElement(locator));
		s.deselectByValue(value);
	}
	public void deSelectByVisibleText(By locator ,String value)
	{
		Select s = new Select(getElement(locator));
		s.deselectByVisibleText(value);
	}
	
	public void deselctAll(By locator)
	{
		Select s= new Select(getElement(locator));
		s.deselectAll();
	}
	
	public boolean isMultiple(By locator)
	{
		Select s= new Select(getElement(locator));
		return s.isMultiple();
	}
	public void getAllSelectedOptions(By locator)
	
	
	{
		List<String> s1= new ArrayList<String>();
		Select s= new Select(getElement(locator));
		
		List<WebElement> ele= s.getAllSelectedOptions();
		for(int i=0;i<ele.size();i++)
		{
	String text=ele.get(i).getText();
	s1.add(text);
	}
		System.out.println(s1);
	}
	
	public void getFirstSelectedOptions(By locator)
	{
		Select s= new Select(getElement(locator));
		String text= s.getFirstSelectedOption().getText();
		System.out.println(text);
	}
	public  void getAllDropDownOptions(By locator)
	{
		Select s= new Select(getElement(locator));
		List<WebElement> ele= s.getOptions();
		for(int i=0;i<ele.size();i++)
		{
			String text=ele.get(i).getText();
			System.out.println(text);
		}
	}
	
	
	public void selectParticularOptions(By locator ,String value)
	{
		Select s= new Select(getElement(locator));
		List<WebElement> ele= s.getOptions();
		for(int i=0;i<ele.size();i++)
		{
			String text=ele.get(i).getText();
			if(text.equals(value))
			{
				ele.get(i).click();
				break;
			}
		}
	}
	
	public void deselectByVisibleText(By locator ,String value)
	{
		Select s= new Select(getElement(locator));
		s.deselectByVisibleText(value);
	}
	

	public void autoDropDown(By locator)
	{
		List<String> s= new ArrayList<String>();
	List<WebElement> ele= getElements(locator);
	System.out.println(ele.size());
	for(int i=0;i<ele.size();i++)
	{
		String text= ele.get(i).getText();
		s.add(text);
	}
	System.out.println(s);
	}
	
	public void particularSelectionWithoutSelectTag(By locator ,String value)
	{
		List<WebElement> ele= getElements(locator);
		System.out.println(ele.size());
		for(int i=0;i<ele.size();i++)
		{
			String text= ele.get(i).getText();
			if(text.equals(value))
			{
				ele.get(i).click();
				
		}
		
		}
	}
	
	public void multiplerSelectionWithoutSelectTag(By locator ,String...value)
	{
		List<WebElement> ele= getElements(locator);
		System.out.println(ele.size());
		for(int i=0;i<ele.size();i++)
		{
			String text= ele.get(i).getText();
			for(int j=0;j<value.length;j++)
			{
				if(text.equals(value[j]))
				{
					ele.get(i).click();
				}
			}
		
		}
	}
	public void selectAllWithoutSelectTag(By locator ,String...value)
	{
		List<WebElement> ele= getElements(locator);
		System.out.println(ele.size());
		if(!value[0].equals("all"))
		{
			for(int i=0;i<ele.size();i++)
			{
				String text= ele.get(i).getText();
				for(int j=0;j<value.length;j++)
				{
					if(text.equals(value[j]))
					{
						ele.get(i).click();
					}
				}
			
			}
		}
		else
		{
		for(int i=0;i<ele.size();i++)
		{
			ele.get(i).click();
		}
		}
	}
	
	
	//***************************************************DropDown end*******************************************************************************************************************
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public ArrayList<Object> getAllLinksText(By locator) {
		ArrayList<Object> a= new ArrayList<>();
		List<WebElement>  ele= getElements(locator);
		for(int i=0;i<ele.size();i++)
		{
			String text=ele.get(i).getText();
		a.add(text);
		}
		return a;
		
		
	}
//**************************************************************Waits*****************************************************************************************

	public WebElement doPresenceOFElementLocated(By locator ,int timeout)

	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	

	public WebElement doPresenceOFElementLocated(By locator ,int timeout ,long intervalTime)

	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(intervalTime));
		return w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement isElementVisible(By locator ,int timeout)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement isElementVisible(By locator ,int timeout ,long intervalTime)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(intervalTime));
		return w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public List<WebElement> isElementVisible(int timeout ,By locator)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	//own millisec set
	public List<WebElement> isElementVisible(int timeout ,By locator, long timeInterval)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(timeInterval));
		return w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public Boolean waitForURLToContain(int timeout,String value)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.urlContains(value));
	}
	
	public Boolean waitForURLToBe(int timeout,String URL)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.urlToBe(URL));
		
	}
	
	public Boolean waitForTitleContains(int timeout ,String value) {
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.titleContains(value));
	}
	public String doGetTitleWithFraction(int timeout ,String value)
	{
		if(waitForTitleContains(timeout,value))
		{
			return driver.getTitle();
		}
		return null;
	}
	
	public Boolean waitForTitleToBe(int timeout ,String value)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.titleIs(value));
		
	}
	public Alert waitForAlert(int timeout)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.alertIsPresent());
	}
	public void doAlertAccept(int timeout)
	{
		waitForAlert(timeout).accept();
	}
	public void doAlertDismiss(int timeout)
	{
		waitForAlert(timeout).dismiss();
	}
	public String getAlertText(int timeout)
	{
		return waitForAlert(timeout).getText();
	}
	public void enterAlertText(int timeout ,String value)
	{
		 waitForAlert(timeout).sendKeys(value);
	}
	
	//Frames
	public void waitForFrameByNameOrId(int timeout ,String value)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(value));
				
	}
	public void waitForFrameByIndex(int timeout ,int index)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
				
	}
	public void waitForFrameByWebElement(int timeout ,By locator)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getElement(locator)));
				
	}
	//FrameLocator
	public void waitForFrameLocator(int timeout ,By locator)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
				
	}
	public void clickElementWhenReady(int timeout ,By locator)
	{
	WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(timeout));
	w.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public WebElement waitForElementPresentUsingFluentWait(int timeout ,int pollingtime ,By locator) 
	{

		Wait<WebDriver> w=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("Element is not found");
		
		return w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	
	public WebElement waitForElementPresentUsingWebDriverWait(int timeout ,int pollingtime ,By locator) 
	{

		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
				
				w.pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("Element is not found");
		
		return w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	//********************************************************Own Custom wait*************************************************************************************************
	public WebElement customWait(int timeout ,By locator)
	{
		WebElement ele= null;
		int attempts=0;
		while(attempts<timeout)
		{
			try
			{
				ele=getElement(locator);
				break;
			}
			catch(Exception e)
			{
				System.out.println("Element is not found :"+ attempts +":"+ locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempts++;
			}
		if(ele==null)
		{
			try
			{
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			}
			catch(Exception e)
			{
				System.out.println("Element is not found...............");
			}
		}
		return ele;
	}
	
	
	}
	
			

