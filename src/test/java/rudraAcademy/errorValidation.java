package rudraAcademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rudraAcademy.pageObjects.cartPage;
import rudraAcademy.pageObjects.productCatalogue;
import rudraAcademy.testcomponents.baseTest;

public class errorValidation extends baseTest{

	@Test(groups= {"ErrorHandling"})
	public  void loginPageValidation() throws IOException {
		
		landingpage.loginApplication("rudraprasad45@gmail.com", "Rudra12");
		
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());		
				
	}
	@Test
	public  void prodctValidation() throws IOException {
		String productName="ADIDAS ORIGINAL";
		landingpage.loginApplication("rudraprasad482@gmail.com", "Rudra123*");
		productCatalogue productcatalogue=new productCatalogue(driver);
		List<WebElement>products=productcatalogue.getProductList(); 
		productcatalogue.addProductToCart(productName);	
		productcatalogue.goToCartPage();	
		cartPage cartpage=new cartPage(driver);
		Boolean match=cartpage.verifyProductDisplay("ADIDAS ORIGINAL1");
	    Assert.assertFalse(match);	
	   }
}
