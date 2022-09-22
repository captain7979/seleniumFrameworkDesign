package rudraAcademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rudraAcademy.AbstractComponents.AbstractComponentTest;

public class confirmationPage extends AbstractComponentTest {

	WebDriver driver;
	
	
	public confirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmationmessage;
	
	public String verifyConfirmationPage()
	{
		return confirmationmessage.getText();
	}
	
}
