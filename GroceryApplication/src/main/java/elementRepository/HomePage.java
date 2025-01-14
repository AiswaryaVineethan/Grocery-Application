package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {//creating constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);//with pagefactory, to use @findby notation
	}
	
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageHeading;
	@FindBy(xpath="//a//p[text()='Sub Category']")
	WebElement subCategoryMenu;
	@FindBy(xpath="//p[text()='Category']")
	WebElement categoryMenu;
	
	public String getHomePageHeading() {
		return homePageHeading.getText();
	}
	
	public SubCategoryPage clickOnSubCategoryMenu() {
		subCategoryMenu.click();
		return new SubCategoryPage(driver);
	}
	
	public CategoryPage clickOnCategoryMenu() {
		categoryMenu.click();
		return new CategoryPage(driver);
	}


}
