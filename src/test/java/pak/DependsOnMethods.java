package pak;

import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test
	public void loginPage()
	{
		System.out.println("Login page test");
		System.out.println(9/0);
	}
	
	@Test(dependsOnMethods="loginPage")
	public void HomePage()
	{
		System.out.println("Home page test");
	}
	
	@Test(dependsOnMethods="loginPage")
	public void searchPage()
	{
		System.out.println("Search page test");
	}

}
