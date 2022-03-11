package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateProfile;
import pages.DeleteProfile;
import pages.LoginPage;

public class LoginTest {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	private LoginPage loginPage;
	private CreateProfile createProfile;
	private DeleteProfile deleteProfile;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		loginPage = new LoginPage(driver);
		createProfile = new CreateProfile(driver, js);
		deleteProfile = new DeleteProfile(driver, js);
		driver.navigate().to("https://qa-interview.united.cloud/login");
		Thread.sleep(1000);
	}

	@Test
	public void logInTest() throws InterruptedException {
		loginPage.logIn("aleksandra.todorovic", "Lozinka123");
		Thread.sleep(1000);
		createProfile.createProfile("Aleksandra", 37, "1984", 5);
		Assert.assertTrue(createProfile.doesMessageExist(), "Message does not exists.");
		Thread.sleep(1000);
		deleteProfile.deleteProfile();
		Assert.assertTrue(deleteProfile.isDeleteSuccessful(), "Unable to delete profile.");

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}