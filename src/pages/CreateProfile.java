package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProfile {

	private WebDriver driver;
	private JavascriptExecutor js;

	public CreateProfile(WebDriver driver, JavascriptExecutor js) {
		super();
		this.driver = driver;
		this.js = js;
	}

	public WebElement getCreateNewProfile() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'button--primary')]"));
	}

	public WebElement getName() {
		return this.driver.findElement(By.id("profile-name"));
	}

	public WebElement getAge(int age) {
		if (age <= 6) {
			return this.driver.findElement(By.xpath("//*[@class = 'age']/*[@id = 'AGE_0_6']"));
		} else if (age <= 11) {
			return this.driver.findElement(By.xpath("//*[@class = 'age']/*[@id = 'AGE_7_11']"));
		} else if (age <= 14) {
			return this.driver.findElement(By.xpath("//*[@class = 'age']/*[@id = 'AGE_12_14']"));
		} else if (age <= 17) {
			return this.driver.findElement(By.xpath("//*[@class = 'age']/*[@id = 'AGE_15_17']"));
		} else {
			return this.driver.findElement(By.xpath("//*[@class = 'age']/*[@id = 'AGE_18_PLUS']"));
		}
	}

	public WebElement getBirthYear() {
		return this.driver.findElement(By.id("year"));
	}

	public WebElement getAvatar(int number) {
		return this.driver.findElement(By.xpath("//*[@class = 'avatars']/div[" + number + "]"));
	}

	public WebElement getCreateProfileButton() {
		return this.driver.findElement(By.xpath("//*[@type = 'submit']"));
	}

	public void createProfile(String name, int age, String year, int avatarNumber) throws InterruptedException {
		Thread.sleep(2000);
		getCreateNewProfile().click();
		getName().sendKeys(name);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", getAge(age));
		if (age >= 18) {
			getBirthYear().sendKeys(year);
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", getAvatar(avatarNumber));
		getAvatar(avatarNumber).click();
		Thread.sleep(2000);
		getCreateProfileButton().click();
	}

	public WebElement getProfileMessage() {
		return this.driver.findElement(By.className("card__lorem"));
	}

	public boolean doesMessageExist() {
		try {
			getProfileMessage();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
