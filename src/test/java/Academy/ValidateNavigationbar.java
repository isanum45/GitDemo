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

public class ValidateNavigationbar extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest 
	public void initialize() throws IOException
	{
		driver  = initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Browser with URL");
		//driver.manage().window().maximize();
	}
	
	@Test
	public void ValidateAppNavbar() throws IOException 
	{
	    LandingPage ipage = new LandingPage(driver);
	    //assertTrue always expect the condition to be true
	    //assertfalse always expect the condition to be false
	    Assert.assertTrue(ipage.getNavigationbar().isDisplayed()); 
	    log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver= null;
	}
}
//Now convert all the Project E2EPROJECT to TestNG.By R.clicking on Project-->TestNG-->convert to TestNG-->Next-->Finish-->TestNG xml file is created after POM.
//Now Right click on TextNG.xml ==>run as -->TestNG suite

/*Now integrating TestNg.xml file into Maven pom.xml
Type into google:testNG maven integration==>select maven surefire plugin==>Using Suite XML files==>copy the plugins
Open pom.xml==>under <url>,create
<build>
Paste the plugin here and remove[..]
</build>

Now R.CLICK on E2EProject-->Properties-->location to copy the path 
Open cmd > cd paste the path==>enter
         > mvn compile==>enter
         > mvn test==>enter==>execution starts
*/
/*Now injecting log4j into maven
 Google:log4j maven dependency-->click on Log4j – Maven, Ivy, Gradle, and SBT Artifacts - Apache Log4j 2
 -->Copy and paste dependency from "Using Log4j in your Apache Maven build" into POM xml File note:from <dependency>
*/
//Now create a file called log4j2/xml in resources Package
//Now add "public static Logger log= LogManager.getLogger(base.class.getName())" to every test case
/*For the POM Xml to recognise log4j2.xml
 * Google:maven resource filtering==>apache maven resources Plugin--Filtering==>Go to upon calling==>
 * Copy and paste from <resources>
 * Now run in CMD USING ABOVE==>Refresh e2eproject after run==>print log is displayed in log folder
 */
 //Now fixing the FW issues by tweaking TestNG xml:BY WRAPPING each  class into one test
//Create screenshot method in Base Class so it can be access in Every Class
//Now the method is created,we use "TESTNG LISTENER"to trigger the screenshot method once a test fails
//Now create a class in src/test/java in Academy called listener using ITestlistener interface
//Create base object to access base method to get screenshoot
//Define the listener class in TestNG xml using "implement ITestListener"
//Run the test as testng suite==.Open test folder created in CDRIVE

//Excellent HTML REPORT Using http://extentreports.com/docs/versions/3/java/==>Click on Maven
//copy the dependency and paste in POM.XML(2 of them)
//Create ExtentReport class in Resources Package
//Run the test from cmd==>refresh the E2EPROJECT==>GO TO TARGETfolder==surefire-report

//Run from jenkins
//Open Jenkins->New item->name as e2eproject->freestyle->OK
//nAVIGATE TO Advanced in General Tab->check use custom workspace
//Note at work,will be given Git credential to get code
//Copy E2EPROJECT AND PASTE AT WHERE .JENKINS IS LOCATED ON CDRIVE
//IN dIRECTOY TEXTFIELD:${JENKINS_HOME}/E2EProject
