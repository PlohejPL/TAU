package pl.edu.pjatk.zad05_selenium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		System.setProperty("webdriver.chrome.driver", "C:/Users/Art/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		driver.get("http://localhost/Projekt-komis_samochodowy/index.php?akcja=brak");
		
		element = driver.findElement(By.linkText("Panel administracyjny"));
		assertNotNull(element);
	}
	
	@Test
	public void polsatPage(){
		driver.get("http://localhost/Projekt-komis_samochodowy/index.php?akcja=brak");
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("E:/tmp/TAU-selenium-screens/beforelogin.png"));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		
		driver.findElement(By.linkText("Panel administracyjny")).click();
		element = driver.findElement(By.name("password"));
		element.sendKeys("haslo");
		element.submit();
		screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("E:/tmp/TAU-selenium-screens/loginresult.png"));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		element = driver.findElement(By.id("Wyloguj"));
		assertNotNull(element);
		element.click();
		
		
		screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("E:/tmp/TAU-selenium-screens/logoutresult.png"));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
