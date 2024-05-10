package mavensample.pageobjects.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponentClass;

public class checkOutPage extends AbstractComponentClass {
	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver; //this refers to the current class instance variable.
		
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//input[@placeholder='Select Country']")
WebElement country;

@FindBy(css=".action__submit")
WebElement submit;

@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
WebElement countryName;

private By results=By.cssSelector(".ta-results");

public void selectCountry(String countryNameId) {
	 Actions a = new Actions(driver);
     a.sendKeys(country,countryNameId).build().perform();

     waitforElementToAppear(By.cssSelector(".ta-results"));
     
     countryName.click();
      
  
}
	public ConfirmAtionPage submitOrder() {
		submit.click();
			
		return new ConfirmAtionPage(driver);
		

	}
	
	
}
