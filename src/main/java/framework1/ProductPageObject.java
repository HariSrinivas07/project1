package framework1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageObject extends BasePage {

	@FindBy (xpath = "//*[@id='homefeatured']/li[1]//a[@class='product-name']")
	public WebElement Firstproduct;
	
	@FindBy (xpath = "//*[@id='short_description_content']/p")
	public WebElement txtPrdtDiscription;
	 	
	/*@FindBy (xpath = "//*[@title='Faded Short Sleeve T-shirts']")
	public WebElement Firstproduct;*/

	@FindBy(xpath = ".//*[@class = 'btn btn-default btn-twitter']")
	public WebElement btnTweet;
	@FindBy(xpath = ".//*[@class = 'btn btn-default btn-facebook']")
	public WebElement btnFBShare;
	@FindBy(xpath = ".//*[@class='btn btn-default btn-google-plus']")
	public WebElement btnGPlus;
	
	public ProductPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickFirstProduct(){
	Firstproduct.click();	
	}
	public WebElement checkdiscrptionsize(){
	return 	txtPrdtDiscription;
	}
	
	public WebElement checkTwitter(){
		return btnTweet;
		}
		public WebElement checkFacebook(){
			return btnFBShare;
		}
		public WebElement checkGoogleplus(){
				return btnGPlus;
		}
	}
