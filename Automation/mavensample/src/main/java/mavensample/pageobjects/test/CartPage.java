package mavensample.pageobjects.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponentClass;

public class CartPage extends AbstractComponentClass {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		//initialization code
		super(driver);
		this.driver=driver; //this refers to the current class instance variable.
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".cartSection h3")
    private  List<WebElement> productTitles;
	@FindBy(css = ".totalRow button")
	WebElement checkOutBut;
	
	
	
	//Actions
	
	
	
	public Boolean matchProductbyName(String productName) {
		Boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		 return match;
	}
    public checkOutPage checkOutButton() {
	checkOutBut.click();
	
	
	return new checkOutPage(driver); 
	
}
	
	
}
