package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

	@Test(groups= {"Smoke"})
	public void ploan() {
		System.out.println("good");
	}
	
	@BeforeTest   //this will be prioritized first over the other tests in the test folder/module
	
	public void prerequisite() {
		System.out.println("i will run first");
	}
	
	
	
}
