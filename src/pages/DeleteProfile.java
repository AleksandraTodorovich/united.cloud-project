package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteProfile {

	private WebDriver driver;
	private JavascriptExecutor js;

	public DeleteProfile(WebDriver driver, JavascriptExecutor js) {
		super();
		this.driver = driver;
		this.js = js;
	}

	private WebElement getDeleteButton() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'button--delete')]"));
	}

	public void deleteProfile() {
		js.executeScript("arguments[0].scrollIntoView();", getDeleteButton());
		getDeleteButton().click();
	}

	public int getArray() {
		return this.driver.findElements(By.className("profiles__profile")).size();
	}

	public boolean isDeleteSuccessful() {
		try {
			return getArray() == 1;
		} catch (Exception e) {
			return false;
		}
	}
}
