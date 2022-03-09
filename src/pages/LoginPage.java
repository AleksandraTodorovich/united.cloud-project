package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUsername() {
		return this.driver.findElement(By.id("username"));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.id("password"));
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'button--primary')]"));
	}

	public void logIn(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
	}
}
