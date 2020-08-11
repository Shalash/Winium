package ProjectName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import winium.elements.desktop.DesktopElement;

// Extends Base class that contains driver setup
public class LoginScreen extends Base {
	
	WiniumDriver driver;
	
// Define screen elements identification variables [Use tool like UISpy to get id, name, and other UI element identification attributes]
	By userName=By.id("txtUsername");
	By passWord=By.id("txtPassword");
	By loginBtn=By.id("btnLogin");
	

	
//Constructor to assign driver to current class object 	
	public LoginScreen(WiniumDriver driver)
	{
		this.driver=driver;
	}
	

// Define methods used to call the elements in Test calse	
	public WebElement  getUserName()
	{
		return  driver.findElement(userName);	
	}
	
	public WebElement  getPassword()
	{
		return  driver.findElement(passWord);
	}
	
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginBtn);
	}
	
	
	
	
}
