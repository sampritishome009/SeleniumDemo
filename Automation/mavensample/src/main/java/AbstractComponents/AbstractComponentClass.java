package AbstractComponents;  //parent class

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavensample.pageobjects.test.CartPage;
import mavensample.pageobjects.test.OrderPage;

public class AbstractComponentClass {
	
	WebDriver driver;
	
	public AbstractComponentClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	
	  @FindBy(css="[routerlink*='cart']")
      WebElement cartHeader;
	  @FindBy(css="[routerlink*='myorders']")
      WebElement orderHeader;
	  

	public void waitforElementToAppear(By findBy) {
		
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
  

	}
	public void waitforWebElementToAppear(WebElement findBy) {
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public  CartPage goToCartPage() {
		cartHeader.click();
	CartPage cartPage=new CartPage(driver);
		return cartPage;
		
		
		}
	
	public   OrderPage goToOrdersPage() {
		orderHeader.click();
	OrderPage orderPage = new OrderPage(driver);
		return orderPage; 
		
		
		}
    public void waitforElementToDisappear(WebElement ele) throws InterruptedException {
    	
    	Thread.sleep(1000);
    	
   //	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
    //	 wait.until(ExpectedConditions.invisibilityOf((ele)));
    }
    

}
