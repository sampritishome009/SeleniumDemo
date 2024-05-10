package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {  //excluding second test or including demo test

	@AfterTest
	public void lastExecution() {
		
		System.out.println("i am executing last");
		
		
	}
	@Parameters({"URL","APIKey/username"})
	@Test
	public void Demo(String urlname,String APIVal) {
		System.out.println("Hello!");
		System.out.println(urlname);
		System.out.println(APIVal);
		
		Assert.assertTrue(false);
	}
	@AfterSuite
	
	public void afSuite() {
		System.out.println("i am at the last");
	}
	
	@Test
	public void SecondTest() {
		
		System.out.println("bye");
	}
}
