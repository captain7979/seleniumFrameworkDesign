package rudraAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rudraAcademy.AbstractComponents.AbstractComponentTest;

public class cartPage extends AbstractComponentTest {
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//driver.findElements(By.cssSelector(" "));
	@FindBy(css=".cartSection h3")
	private List<WebElement>productTitles;
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match=	productTitles.stream().anyMatch(e->e.getText().equalsIgnoreCase(productName));
		return match;
	}
	public checkOutPage goToCheckout()
	{
		checkoutEle.click();
		return new checkOutPage(driver);
	}
	
	
	
	
	
	
	
}
