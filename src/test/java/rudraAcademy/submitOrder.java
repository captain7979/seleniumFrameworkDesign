package rudraAcademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rudraAcademy.pageObjects.cartPage;
import rudraAcademy.pageObjects.checkOutPage;
import rudraAcademy.pageObjects.confirmationPage;
import rudraAcademy.pageObjects.orderPage;
import rudraAcademy.pageObjects.productCatalogue;
import rudraAcademy.testcomponents.baseTest;

public class submitOrder extends baseTest{

	String productName="ADIDAS ORIGINAL";
	@Test(dataProvider = "getData",groups= {"purchaseOrder"})
	public  void submitorder(HashMap<String, String>input) throws IOException {
		
		landingpage.loginApplication(input.get("email"),input.get("password"));
		productCatalogue productcatalogue=new productCatalogue(driver);
		List<WebElement>products=productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("productName"));	
		productcatalogue.goToCartPage();	
		cartPage cartpage=new cartPage(driver);
		Boolean match=cartpage.verifyProductDisplay(input.get("productName"));
	    Assert.assertTrue(match);	
	    cartpage.goToCheckout();		
		checkOutPage cp=new checkOutPage(driver);
		cp.selectCountry("australia");
		confirmationPage cp1= cp.submitPage();
		String confirmessage=cp1.verifyConfirmationPage();		
		System.out.println(confirmessage);
		Assert.assertTrue(confirmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	}
	@Test(dependsOnMethods= {"submitorder"})
	public void orderHistory()
	{
		landingpage.loginApplication("rudraprasad482@gmail.com", "Rudra123*");
		productCatalogue productcatalogue=new productCatalogue(driver);
		orderPage orderpage=productcatalogue.goToOrderHistory();
		Assert.assertTrue(orderpage.verifyOrdertDisplay(productName));
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		/*HashMap<String , String>map=new HashMap<>();
		map.put("email", "rudraprasad482@gmail.com");
		map.put("password", "Rudra123*");
		map.put("productName", "ADIDAS ORIGINAL");
		
		HashMap<String , String>map1=new HashMap<>();
		map1.put("email", "rudra@abc.com");
		map1.put("password", "Abc@1234");
		map1.put("productName", "ZARA COAT 3");*/
		
		List<HashMap<String, String>> data=getJsonDatatpMap(System.getProperty("user.dir")+"\\src\\test\\java\\rudraAcademy\\data\\purchaseOrder.json");	
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}
	
}
