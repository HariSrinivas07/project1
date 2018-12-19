package framework1;

import java.util.List;
import java.util.Random;




import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

	HomePageObject hp;
	BasePage bp;
	WomenPageObject wp;
	DressesPageObject dp;
	TshirtsPageObject tp;

	int value = new Random().nextInt(50000);
	
	public HomePageTest() {
		hp = new HomePageObject();
		bp = new BasePage();
		wp = new WomenPageObject();
		dp = new DressesPageObject();
		tp = new TshirtsPageObject();
	
	}

	@Test
	public void verifytestnavigation() {

		hp.clickWomen();
		Assert.assertTrue(wp.getheaderText().trim().equals("WOMEN"), "Failed : Womens Page not navigated");
		hp.clickDresses();
		Assert.assertTrue(dp.getdressesheaderText().trim().equals("DRESSES"), "Failed : Womens Page not navigated");
		hp.clickTshirts();
		Assert.assertTrue(tp.getTshirtssheaderText().trim().equals("T-SHIRTS"), "Failed : Womens Page not navigated");

	}

	@Test
	public void verifytabs() {
		Assert.assertTrue(hp.dressestabenabled().isDisplayed(),
				"The Dresses tab is not Displayed");
		Assert.assertTrue(hp.tshirtstabenabled().isDisplayed(),
				"The Tshirt tab is not Displayed");
		Assert.assertTrue(hp.womenstabenabled().isDisplayed(),
				"The Womens tab is not Displayed");
	}
	
	@Test
	public void VerifyNewsLetter(){
		String email = "Hariharan"+value+"@gmail.com";
		hp.enterEmailInNewsLetter(email);
	    String alertMessage = hp.getAlertMsg();
	    Assert.assertTrue(alertMessage.contains("Newsletter : You have successfully subscribed to this newsletter."),"Failed : Subscription is not successfull");
	}
	
	@Test
	public void verifyAddtoCart(){
	List<WebElement> products = hp.getProducts();
	for (WebElement element :products ){
		hp.MouseOver(element);
		Assert.assertTrue(hp.verifyAddtoCartbtn(element), "Failed: Add to cart button not Displayed");
	}
	}
	
	}
	
	