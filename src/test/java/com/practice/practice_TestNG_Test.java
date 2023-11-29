package com.practice;

import org.testng.annotations.Test;

public class practice_TestNG_Test {

	
	@Test
	public void Hi () {
		
		System.out.println("----------Hi----------");
	}
	
	@Test(dependsOnMethods = "Hey")
	public void Hello () {
		
		System.out.println("----------Hello----------");
	}
	
	@Test
	public void Hey () {
		
		System.out.println("----------Hey----------");
	}
	
	@Test
	public void Hi_Hi_ () {
		
		System.out.println("----------Hi_Hi_----------");
	}

}
