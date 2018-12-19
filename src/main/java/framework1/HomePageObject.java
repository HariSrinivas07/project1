package framework1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage {

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement Womentab;

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement Dressestab;
	
	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement Tshirtstab;
	
	@FindBy(xpath = "//*[@id='newsletter-input']")
	private WebElement txtBoxNewsLetter;
	
	@FindBy(xpath = "//*[@name='submitNewsletter']")
	private WebElement btnSubmitNewsLetter;
	
	@FindBy(xpath = ".//*[@class = 'alert alert-success']")
	private WebElement txtAlertSuccess;
	
	@FindBys(@FindBy(xpath =".//*[@id='homefeatured']/li"))
	public List<WebElement> Listproducts;

	
	public HomePageObject() {
		PageFactory.initElements(driver,this);
	}

	public WebElement dressestabenabled(){
		return Dressestab;
	}

	public WebElement womenstabenabled(){
		return Womentab;
	}

	public WebElement tshirtstabenabled(){
		return Tshirtstab;
	}
	
	public void clickWomen() {
		Womentab.click();
	}
	
	public void clickDresses() {
		Dressestab.click();
	    }
	
	public void clickTshirts() {
		Tshirtstab.click();
		}

	public void enterEmailInNewsLetter(String email){
		setText(txtBoxNewsLetter, email);
		btnSubmitNewsLetter.click();		
	     }	
	
	public String getAlertMsg(){
	return txtAlertSuccess.getText();
	}
	public List<WebElement> getProducts(){
	return Listproducts;
	}
	
	public boolean verifyAddtoCartbtn(WebElement parent){
		
		return elementFound(parent.findElement(By.xpath(".//*[@title = 'Add to cart']")));
	}
	
	}
	

