package rahulshettyacademy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.AbstractComponentClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import mavensample.pageobjects.test.CartPage;
import mavensample.pageobjects.test.ConfirmAtionPage;
import mavensample.pageobjects.test.LandingPage;
import mavensample.pageobjects.test.OrderPage;
//import mavensample.pageobjects.test.OrderPage;
import mavensample.pageobjects.test.ProductCatalogue;
import mavensample.pageobjects.test.checkOutPage;
import rahulshettyacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest  {
	String productName = "ZARA COAT 3";
	
@Test(dataProvider="getData",groups= {"Purchase"})
public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
	

	

      // String productName = "ZARA COAT 3";
     //  String email = "sampriti.shome009@gmail.com";
       ProductCatalogue productCataloguePage =landingPage.loginApplication(input.get("email"), input.get("password"));  
       
      List<WebElement> products =  productCataloguePage.getProductsList();
    productCataloguePage.addproductToCart(input.get("productName"));
     
       
       
    //go to cart page
       
	CartPage cartPage =productCataloguePage.goToCartPage();//inheritance
      //create cartpage object
     
    
     //next page
   
 
     Boolean match =  cartPage.matchProductbyName(input.get("productName"));
     Assert.assertTrue(match);  //no assertions should be written in page object files.
     checkOutPage chkout= cartPage.checkOutButton();
     chkout.selectCountry("india");
     ConfirmAtionPage confirmationPage = chkout.submitOrder(); 
    String confirmMessage = confirmationPage.getConfirmationMessage();
  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
 
}


@Test(dependsOnMethods={"submitOrder"})

public void OrderHistoryTest() {

	   ProductCatalogue productCataloguePage =landingPage.loginApplication("sampriti.shome009@gmail.com", "Mellon@31");  
	   OrderPage orderPage = productCataloguePage.goToOrdersPage();
	   Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
}



@DataProvider //provids the data into the test cases
public Object[][] getData() throws IOException {
	
	List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//PurchaseOrder.json");
	return  new Object[][] {{data.get(0)},{data.get(1)}};  // since the data in the json file is in the for mat of an array, we can write the syntax : data.get(0)and data.get(1)
}
//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email","Lorraine@gmail.com");
//map.put("password","Mellon@107");
//map.put("productName","IPHONE 13 PRO");
//
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email","sampriti.shome009@gmail.com");
//map1.put("password","Mellon@31");
//map1.put("productName","ZARA COAT 3");

}