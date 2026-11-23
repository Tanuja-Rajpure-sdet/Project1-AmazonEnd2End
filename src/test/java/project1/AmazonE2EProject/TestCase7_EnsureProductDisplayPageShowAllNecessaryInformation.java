package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.github.cdimascio.dotenv.Dotenv;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase7_EnsureProductDisplayPageShowAllNecessaryInformation extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void EnsureProductDisplayPageShowAllNecessaryInformation()
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
		ProductPage ProductPage= new ProductPage(page);
		ProductPage.clickOnCategoryTablet();
		//SearchPage.clickOnCategoryTablet();
		//page.waitForLoadState();
		assertThat(page).hasTitle("Buy Android & iOS Tablets Online with Up to 40% OFF");
		//SearchPage.checkAppleBrandCheckBox();
		ProductPage.selectFirstTablet();
		//SearchPage.selectFirstTablet();
		page.waitForTimeout(3000);
		Locator price = page.locator("#apex-pricetopay-accessibility-label");
		assertThat(price).isVisible();
		assertThat(price).not().hasText("");
		//Scroll down
		Locator L1 = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Product information"));
		assertThat(L1).hasText("Product information");
		
	}
	

}
