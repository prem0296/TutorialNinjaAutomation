package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	
	
   public static WebDriver driver;
   
 
   
  public static Logger logger;
  
	@BeforeSuite
	public void setup(){
		
		logger = LogManager.getLogger(this.getClass());
		
		logger.info("**************************Browser configuration Started *************************************");
	            driver = new ChromeDriver();
	    logger.info("**************************Launching the browser*************************************");
	            driver.get("https://tutorialsninja.com/demo/");
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        
	}
	
	
	 
	 public String  captureScreenShot(String name) throws IOException {
		 LocalDateTime currentDateTime = LocalDateTime.now();		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		 String formattedDateTime = currentDateTime.format(formatter);
		
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);

		 String filepath = System.getProperty("user.dir")+"/ScreenShot/"+name+"_"+formattedDateTime+".png";
		 File file = new File(filepath);
		 FileUtils.copyFile(source, file);
		 
		return filepath;

	}
	 
	 @AfterSuite
		public void tearDown(){
			logger.info("**************************closing the Browser *************************************");
	            driver.quit();
	          
	        
		}
}




























