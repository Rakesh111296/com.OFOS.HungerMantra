package TestNG_Practice;

import org.junit.Ignore;
import org.testng.annotations.Test;

public class Practice_1 {
	
	@Test(priority = 100)
	public void AAA() {
		System.out.println("Test1");
	}

	@Test(priority = 90)
	public void BBB () {
		System.out.println("Test2");
	}
	
	@Test(dependsOnMethods = {"AAA", "BBB"}, priority = 10)
	public void CCC () {
		System.out.println("Test3");
	}
	
	@Test (dependsOnMethods = {"EEE", "AAA"}, priority = 20)
	public void DDD () {
		System.out.println("Test4");
	}
	
	@Test(priority = 50)
	public void EEE () {
		System.out.println("Test5");
	}
}
