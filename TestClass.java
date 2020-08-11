package ProjectName;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testclass extends Base {
	
//To be called before testing
@BeforeTest
public void envSetup() throws IOException, InterruptedException {
		setup();
    }
		

//Test case to be executed

//Login Test case that read userName and Password from TestXML
	@Test @Parameters({ "userName", "passWord"})
	public void login(String userName, String passWord) {
		LoginScreen login = new LoginScreen(driver);
		login.getUserName().sendKeys(userName);
		login.getPassword().sendKeys(password);
		login.getLoginBtn().click();
	}

//Test case to navigate to screen and prerequest that login test case is run successfully [(dependsOnMethods = { "login"})]
@Test(dependsOnMethods = { "login"})
public void clientSearch() throws Exception {
 //Assert that expected behavior matches actual behavior
		Assert.assertEquals(Actual, Expected);
//Assert Element is displayed
		Assert.assertEquals(Element.isDisplayed(), true);
	}

	

}
