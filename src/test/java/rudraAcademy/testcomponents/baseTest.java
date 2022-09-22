package rudraAcademy.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rudraAcademy.pageObjects.LandingPage;

public class baseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\rudraAcademy\\resources\\globalData.properties");
		prop.load(fis);
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless"))
			{
				options.addArguments("headless");	   
			}
			 driver=new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1400, 900));
			 
			
		}
		else if (BrowserName.equalsIgnoreCase("firefox")) {
			
			
		}
        else if (BrowserName.equalsIgnoreCase("edge")) {
			
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	public List<HashMap<String, String>> getJsonDatatpMap(String filePath) throws IOException
	{
		String jsonContent=FileUtils.readFileToString(new File (filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String , String>>data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){}); 
		return data;
		
	}
	
	public String takeScreenShot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage lunchApplication() throws IOException
	{
		driver=initializeDriver();
		 landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
}
