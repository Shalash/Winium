package ProjectName;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;



import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class Base {

	
	protected WiniumDriver driver=null;
	protected WiniumDriverService service = null;
	
  //Define Application undertest path variable
	String appPath="C:\\Program Files (x86)\\ApplicationNameApplication.exe";
  
	//Define properties file path variable
	String filePath="C:\\Work\\AutomationProjects\\ProjectName\\src\\Resources\\global.properties";
	
  //Define winium driver path variable 
	String driverPath="C:\\Work\\AutomationProjects\\ProjectName\\src\\Resources\\Winium.Desktop.Driver.exe";
	
	Properties p=new Properties();
	 

	
	public void setup() throws IOException, InterruptedException
	{
		
		
		// To stop winium desktop driver before start another session
		Process process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
		process.waitFor();
		process.destroy();
		
		// Initiate Winium Desktop Options
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath(appPath);
		
		
		//Lunch winium driver
		Runtime.getRuntime().exec(driverPath+" --port 9998");
		
		
		FileInputStream fi=new FileInputStream(filePath);
		p.load(fi);
		Properties p=new Properties();
		
		//passing the Winium server URL
		driver = new WiniumDriver(new URL("http://localhost:9998"), option);
		
		Thread.sleep(1000);
		

					
		//To Maxmize the screen if required
	/*
		try {
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_WINDOWS);
			} catch (Exception e) {
			e.printStackTrace();
			}
		*/
		
	}

	public void closeDriver()
	{
		driver.close();
	}
			
	

}
