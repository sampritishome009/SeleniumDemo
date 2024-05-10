package mavensample.pageobjects.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentClass;

public class ConfirmAtionPage extends AbstractComponentClass {
	WebDriver driver;
	
	public ConfirmAtionPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //this refers to the current class instance variable.
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	
	
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}
}
