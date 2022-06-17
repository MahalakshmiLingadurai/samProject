package pak;

import org.testng.annotations.Test;

public class Priority {

	
	@Test (priority=-1)
	public void ball()
	{
		System.out.println("I am ball");
	}
	
	@Test (priority=2)
	public void doll()
	{
		System.out.println("I am doll");
	}
	
	@Test (priority=0)
	public void app()
	{
		System.out.println("I am app");
	}
}
