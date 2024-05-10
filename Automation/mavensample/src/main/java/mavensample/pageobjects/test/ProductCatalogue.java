package mavensample.pageobjects.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponentClass;

public class ProductCatalogue extends AbstractComponentClass {
	
	WebDriver driver;
	
	
public ProductCatalogue(WebDriver driver) {
	
	//initialization code
	
	super(driver); // to give driver life to the parent
	this.driver=driver; //this refers to the current class instance variable.
	
	PageFactory.initElements(driver,this);
}

	
	//	WebElement userEmail=  driver.findElement(By.id("userEmail"));
	//PageFactory
		
		@FindBy(css=".col-lg-4")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		@FindBy(css="[routerlink*='cart']")
		WebElement next;
		
		By productsBy = By.cssSelector(".col-lg-4");
		By addToCart=By.cssSelector(".card-body button:last-of-type");
		By toast = By.cssSelector("#toast-container");
		
	//Actions
		public  List<WebElement> getProductsList() {
			waitforElementToAppear(productsBy);   //use By ELEMENT for loading the products using wait.
			return products;  //since we are saving the products value in a webelement list
		}
		public WebElement getProductByName(String productName) {
			//getProductsList is being passed because then it would pick the wait for element until the products are loaded.
			WebElement prod =   getProductsList().stream().filter(product->
		       product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
			
		}
		
		public void addproductToCart(String productName) throws InterruptedException {
			WebElement prod = getProductByName(productName) ;
			prod.findElement(addToCart).click();
			waitforElementToAppear(toast);
			waitforElementToDisappear(spinner);
			
	
		
		}
	
		
		
		}
		
		
		
		

