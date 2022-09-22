package rudraAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rudraAcademy.AbstractComponents.AbstractComponentTest;

public class orderPage extends AbstractComponentTest {
	WebDriver driver;
	public orderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//driver.findElements(By.cssSelector(" "));
	@FindBy(css="tr td:nth-of-type(2)")
	private List<WebElement>productNames;
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public Boolean verifyOrdertDisplay(String productName) {
		Boolean match=	productNames.stream().anyMatch(e->e.getText().equalsIgnoreCase(productName));
		return match;
	}
	public checkOutPage goToCheckout()
	{
		checkoutEle.click();
		return new checkOutPage(driver);
	}
	
	
	
	
	
	
	
}
