package Base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	 @AfterSuite
	public void tearDown(){
		logger.info("**************************closing the Browser *************************************");
            driver.quit();
          
        
	}
}
