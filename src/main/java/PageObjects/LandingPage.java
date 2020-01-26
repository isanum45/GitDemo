package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.xpath("//span[contains(.,'Login')]");
	
	//Deleting PopUp
	By popup=By.xpath("//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[6]/div/div/button");
	
	//Concept of Assertion(Validation
	//Validating "FEATURED COURSES"
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	//Navigation bar
	By navigation = By.xpath("//nav[contains(@class,'navbar-collapse collapse')]");
	
	public LandingPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getPop()
	{
		return driver.findElement(popup);
	}
	public WebElement getNavigationbar()
	{
		return driver.findElement(navigation);
	}

}
