package mavensample.pageobjects.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentClass;

public class LandingPage extends AbstractComponentClass{
	
	WebDriver driver;
	
	
public LandingPage(WebDriver driver) {
	
	//initialization code
	super(driver);
	this.driver=driver; //this refers to the current class instance variable.
	
	PageFactory.initElements(driver,this);
}

	
	//	WebElement userEmail=  driver.findElement(By.id("userEmail"));
	//PageFactory
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEl;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public ProductCatalogue loginApplication(String email,String password) {
			
			userEmail.sendKeys(email);
			passwordEl.sendKeys(password);
			submit.click();
			 ProductCatalogue productCataloguePage = new ProductCatalogue(driver);//definiting the object overhere since we know that after the submit click , the product cat. page will open
			 return productCataloguePage;
			
		}	//page object segregartion for landing page url
			
		
		public String getErrorMessage() {
			
			waitforWebElementToAppear(errorMessage);
			return errorMessage.getText();
			
			
		}
		
		
			public void goTo() {
			
				driver.get("https://rahulshettyacademy.com/client");
		}

			
		
		
		
		
}