package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Dimension;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavensample.pageobjects.test.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initilaizeDriver() throws IOException {
		
		Properties prop = new Properties();
		//FileInputStream--> converts file into input stream object.
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src/main/java/mavensample/resources/GlobalData.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		
		if ( browsername.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
		   WebDriverManager.chromedriver().setup();
		   
		   if(browsername.contains("headless")) {
			   options.addArguments("headless");   
		   }
	       driver = new ChromeDriver(options); //options object tells the browser t run the code in headless mode.
           driver.manage().window().setSize(new Dimension(1440,900)); //full screen
	}

		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/sampritishome//Downloads//geckodriver");
			driver = new FirefoxDriver();
			
			
		
		}
		
		else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "//Users//sampritishome//Downloads//edgedriver_arm64 (1)");
			driver = new EdgeDriver();
		  
		
	}
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //max timeout
	       driver.manage().window().maximize();
		return driver;
	           
	       
}
	//utility to tahe screenshots is now in basetest

public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	
	File src = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+"//src//test//java//test-output//"+testCaseName+".png");
	FileUtils.copyFile(src,file);
	return System.getProperty("user.dir")+"//src//test//java//test-output//"+testCaseName+".png";
}
	
	
	
	
	
	
	
	
	
	@BeforeMethod(alwaysRun=true) // before method bypasses the calling of launch application() in the main test file. and AlwaysRun includes all groups all everytime time.
	public LandingPage launchApplication() throws IOException {
		driver = initilaizeDriver();
		landingPage	=new LandingPage(driver);
		landingPage.goTo();//lands you on landing pagre in the ecommerce app.

		return landingPage;
	}
	
public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException {
		
		//read json to string
		
	String jsonContent = 	FileUtils.readFileToString(new File(filePath),
	StandardCharsets.UTF_8);
	//String to HashMap Jackson databind
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
	
	});
	return data;
}

	@AfterMethod
	public void tearDown() {
		driver.close();
		
	
	}
	
	
}