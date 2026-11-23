package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase8_SortProductBasedOnRelevancePriceRatings extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void SortProductBasedOnRelevancePriceRatings()
	{
		HomePage HomePage= new HomePage(page);
		
		HomePage.hoverOverOnAccountAndList();
		page.waitForLoadState();
		HomePage.clickOnSignin();
		assertThat(page).hasTitle("Sign in");
		
		LoginPage LoginPage = new LoginPage(page);
		
		LoginPage.enterUsername(getEnvValue("Amazon_un"));
		LoginPage.clickOnContinue();
		LoginPage.enterPassword(getEnvValue("Amazon_pwd"));
		LoginPage.clickOnSignin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		SearchPage SearchPage = new SearchPage(page);
		SearchPage.clickOnSearchDropBox();
		SearchPage.clickOnSearchBotton();
		assertThat(page).hasTitle("Shop Electronics: Massive 70% Discounts on Top Brands | Amazon.in");
		ProductPage ProductPage= new ProductPage(page);
		ProductPage.clickOnCategoryTablet();
		//SearchPage.clickOnCategoryTablet();
		//page.waitForLoadState();
		assertThat(page).hasTitle("Buy Android & iOS Tablets Online with Up to 40% OFF");
		//Select product based on relevance, brand, price
		Locator brands= page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Shop Tablets by Brands"));
		assertThat(brands).isVisible();
			
		Locator price= page.locator("div[id='p_36-title'][class='a-section a-spacing-small']");
		assertThat(price).isVisible();
		ProductPage.checkAppleBrandCheckBox();
		//SearchPage.checkAppleBrandCheckBox();
		//SearchPage.selectPriceRangeTablet();
		
		SearchPage.clickOnSearchNextPage();
		page.waitForTimeout(3000);
		
	}
	

}
