package framework1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObject extends BasePage {

	@FindBy(xpath = "//*[@class='cat-name']")
	private WebElement dressesheader;

	@FindBy(xpath = ".//*[@class = 'heading-counter']")
	public WebElement txtProductHeaderCount;

	@FindBys(@FindBy(xpath = ".//*[@class = 'product_list grid row']/li"))
	public List<WebElement> lstProducts;
	@FindBys(@FindBy(xpath = "//*[@class='product_list row list']/li"))
	public List<WebElement> DressesPageProducts;
	@FindBy(xpath = "//*[@id='center_column']/ul/li[3]/div/div/div[2]/div[1]/span")
	public WebElement reducedpricetxt;
	

	@FindBy(xpath = "//*[@id='social_block']/ul/li[1]/a")
	public WebElement btnFacebook;
	@FindBy(xpath = "//*[@id='social_block']/ul/li[2]/a")
	public WebElement btnTwitter;
	@FindBy(xpath = "//*[@id='social_block']/ul/li[3]/a")
	public WebElement btnYoutube;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]/span")
	public WebElement btnAddCart3rddress;
	@FindBy(xpath = ".//*[@class='icon-ok']")
	public WebElement prdtaddedTxt;

	@FindBy(xpath = "//*[@id='layered_id_attribute_group_1']")
	public WebElement btnSmall;
	@FindBy(xpath = "//*[@id='layered_id_attribute_group_2']")
	public WebElement btnMedium;
	@FindBy(xpath = "//*[@id='layered_id_attribute_group_3']")
	public WebElement btnLarge;

	@FindBy(xpath = "//*[@class='icon-th-list']")
	public WebElement listbtn;
	
	@FindBy (xpath = "//*[@id='selectProductSort']")
	public WebElement dropDownSort;
	@FindBys(@FindBy (xpath = "//*[@class='left-block']//*[@class = 'price product-price']"))
	private List<WebElement> lstprices;
	@FindBy (xpath ="//*[@id='layered_ajax_loader']")
	public WebElement loadingtime;
	
	


	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}

	public String getdressesheaderText() {
		return dressesheader.getText();

	}

	public int getProductCount() {
		return lstProducts.size();
	}

	public int getProductCountFromHeader() {
		return Integer.parseInt(txtProductHeaderCount.getText().split(" ")[2]);
	}

	/* Method Functions for Checking the Small , Medium and Large radio buttons */

	public WebElement chckSmallbtn() {
		return btnSmall;
	}

	public WebElement chckMediumbtn() {
		return btnMedium;
	}

	public WebElement chckLargebtn() {
		return btnLarge;
	}

	public void clickListbtn() {
		listbtn.click();
	}

	public List<WebElement> getDressesPageProducts() {
		return DressesPageProducts;
	}
	
	public WebElement getReducedPricetxt() {
		return reducedpricetxt;
	}

	public boolean verifyReducedCostPrdt(WebElement parents) {

		return elementFound(parents.findElement(By
				.xpath(".//*[@class='price-percent-reduction']")));
	}
	
	public void selectSortBy(String options){
		selectFromDropDown(dropDownSort, options);
	}
	
	public ArrayList<Double> getProductPrices(){
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		isElementVisible(loadingtime);
		isElementInVisible(loadingtime);
		
		for (WebElement e : lstprices){
		String text = e.getText();
		text = text.replace("$","").trim();
		Double value = Double.parseDouble(text);
		list.add(value);
		}
		return list;
	
    }
	}
