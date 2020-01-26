package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.LandingPage;
import Resources.base;

public class ValidateTitle extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest 
	public void initialize() throws IOException
	{
		driver  = initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		log.info("Navigated to home");
		//driver.manage().window().maximize();
	}
	
	@Test
	
	public void ValidateAppTitle() throws IOException 
	{
		
	    LandingPage ipage = new LandingPage(driver);
	    //Click on Popup
	    ipage.getPop().click();
	    //compare the text from the browser with actual text.If No match Error should be displayed
	    //actual String = ipage.getTitle().getText()
	    //Expected String = Featured Courses
	    Assert.assertEquals(ipage.getTitle().getText(),"FEATURED COURSES");
	    //use below to get screenshot
	    //Assert.assertEquals(ipage.getTitle().getText(),"FEATURED COURSES123");
	    log.info("Successfully validate Text Message");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver= null;
	}
	}

