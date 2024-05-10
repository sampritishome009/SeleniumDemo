package mavensample.pageobjects.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentClass;

public class OrderPage  extends AbstractComponentClass {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //this refers to the current class instance variable.
		
		PageFactory.initElements(driver,this);
	}

    @FindBy(css="table tbody tr td:nth-child(3)")
    private  List<WebElement> productNames;
	@FindBy(xpath="//div/ul/li/button")
	WebElement checkOutBut;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		
		 return match;
	}
}
