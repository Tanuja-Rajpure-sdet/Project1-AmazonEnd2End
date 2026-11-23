package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase2_LoginToAmazonWithValidCredentials extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void loginToWithValidCredentials()
	{ 
		HomePage HomePage = new HomePage(page);
		HomePage.hoverOverOnAccountAndList();
		HomePage.clickOnSignin();
		Reporter.log("Successfully navigated through Amazon home page.");
		
		LoginPage LoginPage = new LoginPage(page);
		
		//Dotenv env= Dotenv.load();
		
		//LoginPage.enterUsername(ConfigReader.get("Amazon_un"));
		LoginPage.enterUsername(getEnvValue("Amazon_un"));
		LoginPage.clickOnContinue();
		//LoginPage.enterPassword("Amazon_pwd");
		LoginPage.enterPassword(getEnvValue("Amazon_pwd"));
		LoginPage.clickOnSignin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Reporter.log("User Successfully logged in Amazon.in.");
		
		
	}

}
