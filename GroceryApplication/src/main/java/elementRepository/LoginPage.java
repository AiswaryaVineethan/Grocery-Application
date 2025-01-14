package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {//creating constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);//page object model with pagefactory, to use @findby notation
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameField;
	@FindBy(name="password")
	WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement alert;
	
	public HomePage login(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}

	public String AlertMessage() {
		return alert.getText();
		
	}
		


}
