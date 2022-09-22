package rudraAcademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rudraAcademy.AbstractComponents.AbstractComponentTest;

public class LandingPage extends AbstractComponentTest{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//WebElement user=driver.findElement(By.id());
	//pagefactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Elepassword;
	
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public void loginApplication(String email,String Password) {
		userEmail.sendKeys(email);
		Elepassword.sendKeys(Password);
		submit.click();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
	
	
	
	
	
}
