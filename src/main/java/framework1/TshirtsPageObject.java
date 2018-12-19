package framework1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtsPageObject extends BasePage{

	@FindBy(xpath = "//*[@class='cat-name']")
	private WebElement Tshirtssheader;

	public TshirtsPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTshirtssheaderText() {
		return Tshirtssheader.getText();
		
	}
}
