package Resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();
		FileInputStream fis = new FileInputStream ("C:\\Users\\dak05_000\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dak05_000\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dak05_000\\Downloads\\chromedriver_win32\\chromedriver.exe");
		     driver = new ChromeDriver();
		}
		else if (browserName.equals("internetexplorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\dak05_000\\Downloads\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//create a folder in C-drive called "test"
		FileUtils.copyFile(src, new File("C:\\test\\"+result+"screenshot.png"));
	}
}

