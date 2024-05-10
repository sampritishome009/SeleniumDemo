package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before executing any methods in the class");
	}
	@Parameters({"URL"})
	@Test
	public void WebCarLogin(String urlname) {
		System.out.println("webLoginCar");
		System.out.println(urlname);
	}
	@BeforeMethod
	
	public void beforeevery() {
		System.out.println("i will execute before each method");
	}
	@AfterMethod
	
	public void afterevery() {
		System.out.println("i will execute after each method");
	}
	
	@AfterClass
	
	public void afterClass() {
		System.out.println("after executing any methods in the class");
	}
	@Test(groups= {"Smoke"})
	public void MobileLoginCarLoan() {
		System.out.println("mobileLoginCar");
	}
	
	
	@BeforeSuite
	public void BfSuite() {
		System.out.println("i am no#1");
	}
   @Test
   public void MobileSignInCarLoan() {
   

  System.out.println("Sign in ");
   
}
   @Test(dataProvider="getData")
   public void MobileSignOutCarLoan(String username,String password) {
   System.out.println(username);
   System.out.println(password);

  System.out.println("Sign Out");
   
}
   @Test(dependsOnMethods={"WebCarLogin","MobileSignInCarLoan"})
   public void APILoginCarLoan() {
   
//ex. Rest API authentication
  System.out.println("API Log in Car");
   
}
   @DataProvider
   public Object[][] getData() {
	   //1st combo : username,password --good credit history
	   //2nd: username,password - no credit history
	   //3rd: fraudulant credit history
	   
	   Object[][] data=new Object[3][2]; //row number: how many combinations are there(3),col number : how many values we are passing(2).
	   data[0][0]="firstsetusername";
	   data[0][1]="firstpassword";
	   //columns in the row are values for that particular combination.
	   //2nd set
	   
	   data[1][0]="secondsetusername";
	   data[1][1]="secondpassword";
	   
	   //3rd set
	   
	   data[2][0]="thirdsetusername";
	   data[2][1]="thirdpassword";
	   
	   return data;
	   
	   
   }
   
   
}