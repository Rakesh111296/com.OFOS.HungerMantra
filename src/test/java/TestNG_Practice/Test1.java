package TestNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test1 {
	
	@BeforeSuite
	public void BS () {
		System.out.println("BeforeSuite");
	}
	
	@BeforeClass
	public void BC () {
		System.out.println("BeforeClass");
	}
	
	@BeforeClass
	public void BC1 () {
		System.out.println("BeforeClass1");
	}
	
	@Test
	public void Test1 () {
		System.out.println("Test1");
	}
	
	@BeforeMethod
	public void BM () {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void AM () {
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void AC () {
		System.out.println("AfterClass");
	}
	
	@Test
	public void Test2 () {
		System.out.println("Test2");
	}
	
	@BeforeMethod
	public void BM1 () {
		System.out.println("BeforeMethod1");
	}
	
	@AfterClass
	public void AC1 () {
		System.out.println("AfterClass1");
	}

	
	@BeforeMethod
	public void BM2 () {
		System.out.println("BeforeMethod2");
	}
	
	@AfterMethod
	public void AM1 () {
		System.out.println("AfterMethod1");
	}
	
	@AfterSuite
	public void AS () {
		System.out.println("AfterSuite");
	}
}
