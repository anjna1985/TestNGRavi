package demoTestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoTestNG {

	WebDriver driver;
	
	@BeforeSuite
	public void connectionEstablished() {

		System.out.println("Connection Established");
	}

	@BeforeTest
	public void openBrowser() {
		System.out.println("launching chrome browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}

	// -------List of TCs
	@Test(priority = 1)
	public void titleValidation() {
		System.out.println("Title Check");
	}

	@Test(priority = 2)
	public void imageValidation() {
		System.out.println("Image Validation");
	}

	@Test(priority = 3)
	public void webElementExist() {
		System.out.println("Web Element Present/Exist");
	}

	// ----- Test Cases End

	@AfterTest
	public void closeBrowser() {
		System.out.println("Closing Browser");
	}

	@AfterSuite
	public void disConnect() {
		System.out.println("Disconnect From DB");
	}

}
