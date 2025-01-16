package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageContactPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody//tr//td[6]")
	WebElement editButton;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneFiled;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailFiled;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressFiled;
	@FindBy(xpath="//textarea[@name='del_time']")
	WebElement deliveryTimeFiled;
	@FindBy(xpath="//input[@id='del_limit']")
	WebElement deliveryChargeLimitFiled;
	@FindBy(xpath="//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	
	public static String groceryApplicationLogin(int row, int col) throws IOException {
		String data = ExcelUtilities.readExcelData(row, col,
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\GroceryApplicationData.xlsx",
				"sheet1");
		return data;
	}
	
	public void editContactUsDetails(String phonenum,String email, String address, String deliveryTime,String deliveryChargeLimit) throws InterruptedException {
		editButton.click();
		phoneFiled.sendKeys(phonenum);
		emailFiled.sendKeys(email);
		addressFiled.sendKeys(address);
		deliveryTimeFiled.sendKeys(deliveryTime);
		deliveryChargeLimitFiled.sendKeys(deliveryChargeLimit);
		gu.scrollTestUsingWindowScrollByFunction(driver, 0, 1500);
		Thread.sleep(2000);
		updateButton.click();		
		
	}
	
	public String getSuccessAlertMessage() {
		return successAlertMessage.getText();
	}
	

}
