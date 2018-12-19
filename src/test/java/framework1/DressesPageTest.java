package framework1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DressesPageTest {
	HomePageObject hp;
	BasePage bp;
	WomenPageObject wp;
	DressesPageObject dp;
	TshirtsPageObject tp;

	public DressesPageTest() {

		hp = new HomePageObject();
		bp = new BasePage();
		wp = new WomenPageObject();
		dp = new DressesPageObject();
		tp = new TshirtsPageObject();

	}

	@Test
	public void verifyProductCount() {
		hp.clickDresses();
		Assert.assertEquals(dp.getProductCount(),
				dp.getProductCountFromHeader(), "Failed Count Mismatch");
	}

	/*
	 * @Test public void vfySiginAtCheckout(){ hp.clickDresses();
	 * dp.clickaddcart3rddress();
	 * System.out.println(dp.getTxtASigninAtCheckout());
	 * Assert.assertTrue(dp.getTxtASigninAtCheckout
	 * ().equals("CREATE AN ACCOUNT"),
	 * "Sigin Page is not didplaying after clicking cheout " ); }
	 */

	@Test
	public void verifySizes() {
		hp.clickDresses();
		
		Assert.assertTrue(dp.chckSmallbtn().isEnabled());
		Assert.assertTrue(dp.chckMediumbtn().isEnabled());
		Assert.assertTrue(dp.chckLargebtn().isEnabled());

	}

	@Test
	public void verifyReducedCostProduct() {
		hp.clickDresses();
		dp.listbtn.click();
		List<WebElement> Dressproducts = dp.getDressesPageProducts();
		for (WebElement elements : Dressproducts) {
			dp.MouseOver(elements);
			if (dp.verifyReducedCostPrdt(elements)) {
				Assert.assertTrue(dp.elementFound(dp.getReducedPricetxt()),
						"Failed: MisMatching");
			}

		}
	}

	@Test
	public void verifyPricesInAscendingOrder() {
		hp.clickDresses();
		dp.selectSortBy("price:asc");
		ArrayList<Double> prices = dp.getProductPrices();
		for (Double d : prices) {
			System.out.println(d);
		}
		for (int i = 0; i < prices.size() - 1; i++) {
			Assert.assertTrue(prices.get(i) < prices.get(i + 1),
					"Failed : Not arrnaged in ascending order");
		}
	}

}
