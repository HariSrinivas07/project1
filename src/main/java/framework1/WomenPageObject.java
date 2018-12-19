package framework1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPageObject extends BasePage {

	@FindBy(xpath = "//*[@class='cat-name']")
	private WebElement womenheader;

	@FindBy(xpath = "//*[@id='columns']/p")
	private WebElement SubscriptionSuccessfullText;

	public WomenPageObject() {
		PageFactory.initElements(driver, this);
	}

	public String getheaderText() {
		return womenheader.getText();
	}

	public WebElement getSubscriptionSuccesffultext() {
		return SubscriptionSuccessfullText;

	}
}
