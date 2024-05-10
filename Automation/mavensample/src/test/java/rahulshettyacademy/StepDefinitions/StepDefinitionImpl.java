package rahulshettyacademy.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mavensample.pageobjects.test.CartPage;
import mavensample.pageobjects.test.ConfirmAtionPage;
import mavensample.pageobjects.test.LandingPage;
import mavensample.pageobjects.test.ProductCatalogue;
import mavensample.pageobjects.test.checkOutPage;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest{
public LandingPage landingPage;
public ProductCatalogue productCataloguePage;
public ConfirmAtionPage confirmationPage;
public CartPage cartPage ;

	@Given("i land on Ecommerce page")
	
	public void I_landed_on_Ecommerce_Page() throws IOException{
		landingPage=launchApplication();   //gets life here.
		
	}
    @Given("^Logged in with username (.+) and password (.+)$")  //we must use an ^ and end the code with a $ sign to mark it as a regular expression
    public void logged_in_username_and_password(String username,String password) {    //these arguments are catching the parameters of username and password.
    	productCataloguePage =landingPage.loginApplication(username,password);  
    	
}
    
    @When("^I add product (.+) to Cart$")
    public void i_add_product_product_to_cart(String productName) throws InterruptedException {
    	
    	List<WebElement> products =  productCataloguePage.getProductsList();
    	productCataloguePage.addproductToCart(productName);

    }
    

	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		 cartPage = productCataloguePage.goToCartPage();

		Boolean match = cartPage.matchProductbyName(productName);
		Assert.assertTrue(match);
		checkOutPage chkout= cartPage.checkOutButton();
		chkout.selectCountry("india");
	      confirmationPage = chkout.submitOrder(); 
	}
    
    @Then("{string} message is displayed on CofirmationPage")
    public void message_is_displayed_on_confirmationPage(String string) {
    	 String confirmMessage = confirmationPage.getConfirmationMessage();
    	  Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    	  driver.close();
    	  }
    @Then("{string} message is dispalyed")
    public void something_message_is_displayed(String string) throws Throwable  {
   
    	Assert.assertEquals(string, landingPage.getErrorMessage());
    	driver.close();
    	
    }
}
