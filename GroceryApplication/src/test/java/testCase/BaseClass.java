package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;// driver declared as instance variable to use this driver in both before and
						// after method
	ScreenShotCapture sc;

	public static Properties pro;

	public static String groceryApplicationLogin(int row, int col) throws IOException {
		String data = ExcelUtilities.readExcelData(row, col,
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\GroceryApplicationData.xlsx",
				"sheet1");
		// String data = ExcelUtilities.readExcelData(row,
		// col,"D:\\Eclipse_Workspace\\GroceryApplication\\src\\main\\resources\\Excel\\GroceryApplicationData.xlsx","sheet1");
		return data;
	}

	public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		pro.load(fp);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserName) throws IOException {
		testBasic();
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
	
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(pro.getProperty("BaseUrl"));// getting key value(url) from config.properties
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)

	public void afterMethode(ITestResult iTestResult) throws IOException {//iTestResult-listener class :listen the project

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			sc = new ScreenShotCapture();

			sc.captureFailureScreenShot(driver, iTestResult.getName());//Testcase name getName

		}

	//driver.quit();

	}

}
