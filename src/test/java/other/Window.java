package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {

HashMap<String , Integer > a= new HashMap<String , Integer>();
a.put("maha",2);
a.put("muthu",3);
a.put("thangam",1);
a.put("saras",4);
a.put("shiva",5);
Iterator<String> it = a.keySet().iterator();
while(it.hasNext())
{
	String key= it.next();
	Integer value= a.get(key);
	System.out.println(key +":"+ value);
}






	}

}
