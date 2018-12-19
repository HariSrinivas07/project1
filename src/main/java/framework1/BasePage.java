package framework1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	static WebDriver driver;
	public String browser = "chrome";

	public BasePage() {
		if (driver == null) {
			if (browser.equals("chrome")) {

				System.setProperty(
						"webdriver.chrome.driver",
						"C:\\Users\\Krishna\\Downloads\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:/Users/abu/workspace/Pom/Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
		}
	}

	public boolean isTextPresent(String text) {
		try {
			boolean b = driver.getPageSource().contains(text);
			return b;
		} catch (Exception e) {
			return false;
		}
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.clear();
			element.sendKeys(name);
		}
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public void SwitchWindows(int index) throws Exception {
		String currentWindow = driver.getWindowHandle();
		System.out.print(currentWindow);
		Set<String> allwindows = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>();
		if(index > list.size()){
			throw new Exception("Enter index window is not present");
		}
		list.addAll(allwindows);
		driver.switchTo().window(list.get(index));
	}
	
	public void switchToMainWindow(){
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(driver.getWindowHandles());
		driver.switchTo().window(list.get(0));
	}
	
	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	public void MouseOver(WebElement we){
		Actions actObj=new Actions(driver);
		actObj.moveToElement(we).build().perform();
		}
	
	public boolean isElementInVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
		public String selectFromDropDown(WebElement element, String option) {
			Select obj = new Select(element);
			obj.selectByValue(option);
			return obj.getFirstSelectedOption().getText();
		}

}
