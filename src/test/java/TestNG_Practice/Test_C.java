package TestNG_Practice;

import org.testng.annotations.Test;

import com.GenricUtilities.Admin_Bass_Class;

public class Test_C extends Admin_Bass_Class{

	@Test 
	public void testC1() {
		System.out.println("----TestC1---");
	}
	
	@Test
	public void testC2() {
		System.out.println("----TestC2---");
	}
}
