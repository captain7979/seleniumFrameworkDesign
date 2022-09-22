package rudraAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rudraAcademy.AbstractComponents.AbstractComponentTest;

public class productCatalogue extends AbstractComponentTest {
	WebDriver driver;
	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//driver.findElements(By.cssSelector(" "));
	@FindBy(css=".mb-3")
	List<WebElement>products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productBy=By.cssSelector(".mb-3 ");
	By addtoCart=By.cssSelector(".card-body button:last-of-type");
	By toaster=By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		 WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			
			return prod;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addtoCart).click();
		waitForElementToAppear(toaster);
		waitForElementToDisappear(spinner);
		
	}

	
	
	
	
	
}
