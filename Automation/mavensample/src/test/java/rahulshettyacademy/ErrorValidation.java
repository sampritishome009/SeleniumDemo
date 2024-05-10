package rahulshettyacademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mavensample.pageobjects.test.CartPage;
import mavensample.pageobjects.test.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;

public class ErrorValidation extends BaseTest  {
	
	
@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
public void LoginErrorValidation() throws IOException, InterruptedException {
	

	

    //   String productName = "ZARA COAT 3";
     //  String email = "sampriti.shome009@gmail.com";
      landingPage.loginApplication("rahulshdssetty.shome009@gmail.com", "Mellon@3102");  
      ////div[@aria-label='Incorrect email or password.']
       //div[aria-label='Incorrect email or password.']
       
      
       
       Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
}

public class SubmitOrderTest extends BaseTest  {
	
	
@Test  //each @Test is a seperate test case
public void ProductErrorValidation() throws IOException, InterruptedException {
	

	

       String productName = "ZARA COAT 3";
     //  String email = "sampriti.shome009@gmail.com";
       ProductCatalogue productCataloguePage =landingPage.loginApplication("sampriti.shome009@gmail.com", "Mellon@31");  
       
      List<WebElement> products =  productCataloguePage.getProductsList();
    productCataloguePage.addproductToCart(productName); 
    //go to cart page
       
	CartPage cartPage =productCataloguePage.goToCartPage();//inheritance
      //create cartpage object
     
    
     //next page
   
 
   Boolean match =  cartPage.matchProductbyName("ZARA COAT 33");
  
     Assert.assertFalse(match);  //no assertions should be written in page object files.
    
 
}
}
}