package rudraAcademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rudraAcademy.AbstractComponents.AbstractComponentTest;

public class checkOutPage extends AbstractComponentTest {
	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".btnn")
	WebElement submit;
	
	
	

	@FindBy(css=".ta-item:nth-of-type(1)")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}
	
	public confirmationPage submitPage() {
		submit.click();
		return new confirmationPage(driver);
		
	}

}
