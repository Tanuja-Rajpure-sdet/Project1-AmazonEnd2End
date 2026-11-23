package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import io.github.cdimascio.dotenv.Dotenv;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase6_SearchingProductWithFilters extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void SearchingProductWithFilters()
	{
		HomePage HomePage= new HomePage(page);
		HomePage.hoverOverOnAccountAndList();
		page.waitForLoadState();
		HomePage.clickOnSignin();
		assertThat(page).hasTitle("Sign in");
		
		LoginPage LoginPage = new LoginPage(page);
		Dotenv env = Dotenv.load();
		LoginPage.enterUsername(env.get("Amazon_un"));
		LoginPage.clickOnContinue();
		LoginPage.enterPassword(env.get("Amazon_pwd"));
		LoginPage.clickOnSignin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		SearchPage SearchPage = new SearchPage(page);
		SearchPage.clickOnSearchDropBox();
		SearchPage.clickOnSearchBotton();
		assertThat(page).hasTitle("Shop Electronics: Massive 70% Discounts on Top Brands | Amazon.in");
		ProductPage ProductPage = new ProductPage(page);
		ProductPage.clickOnCategoryLaptop();
		//SearchPage.clickOnCategoryLaptop();
		//page.waitForLoadState();
		assertThat(page).hasTitle("Laptops: Buy Laptop Online with Up to 35% OFF");
		ProductPage.selectPriceRange();
		//SearchPage.selectPriceRange();
		Locator L1= page.locator("//span[text()='Price Laptops']");
		assertThat(L1).hasText("Price Laptops");
	}
	

}
