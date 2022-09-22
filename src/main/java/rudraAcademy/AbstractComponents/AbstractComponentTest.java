package rudraAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rudraAcademy.pageObjects.orderPage;

public class AbstractComponentTest {
	WebDriver driver;
	public AbstractComponentTest(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHistory;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public void goToCartPage()
	{
		cartHeader.click();
		
	}
	
	public orderPage goToOrderHistory()
	{
		orderHistory.click();
		orderPage orderpage=new orderPage(driver);
		return orderpage;
		
	}
	
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	}
	
	
	

}
