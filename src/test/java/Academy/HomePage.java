package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class HomePage extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest 
	public void initialize() throws IOException
	{
		driver  = initializeDriver();
		log.info("Driver is initialize");
	}
	
	@Test(dataProvider ="getData")
	
	public void basePageNavigation(String Username,String Password,String Text) throws IOException //no of argument dependent on no of rows and columns 
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Browser with Url");
		//driver.manage().window().maximize();
	    LandingPage ipage = new LandingPage(driver);
	    ipage.getLogin().click();
	    
	    LoginPage lpage = new LoginPage(driver);
	    lpage.getEmail().sendKeys(Username);
	    lpage.getPassword().sendKeys(Password);
	    //System.out.println(Text);
	    log.info(Text);
	    lpage.getLogin().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver= null;
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
	  //Row stands for how many different data types test should run
	  //Column stands for how many values per each text
		
		Object[][] data = new Object[2][3]; //2 rows and 2 columns.Object takes total counts ; Object[total row][total column], not index.
		//Array size 3=> 0,1,2
		//Array size 1=> 0
		//0 row
		data[0][0]= "isdak5@yahoo.com";
		data[0][1]= "45678";
		data[0][2]= "restricteduser";
		
		//First row
		data[1][0]= "isdak5567@yahoo.com";
		data[1][1]= "78654";
		data[1][2]= "nonrestricteduser";
		
		return data;
	}
}
