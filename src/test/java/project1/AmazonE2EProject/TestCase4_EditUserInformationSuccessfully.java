package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase4_EditUserInformationSuccessfully extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void editUserInformationSuccessfully() 
{
		HomePage HomePage= new HomePage(page);
		HomePage.hoverOverOnAccountAndList();
		page.waitForLoadState();
		HomePage.clickOnSignin();
		assertThat(page).hasTitle("Sign in");
		
		LoginPage LoginPage = new LoginPage(page);
		//Dotenv env = Dotenv.load();
		LoginPage.enterUsername(getEnvValue("Amazon_un"));
		LoginPage.clickOnContinue();
		LoginPage.enterPassword(getEnvValue("Amazon_pwd"));
		LoginPage.clickOnSignin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		page.waitForLoadState();
		HomePage.hoverOverOnAccountAndList();
		HomePage.clickonYourAccount();
		assertThat(page).hasTitle("Your Account");
		
		YourAccountPage AccountPage = new YourAccountPage(page);
		
		AccountPage.clickOnAccountSettingsDropDown();
		AccountPage.clickOnLoginAndSecurity();
		page.waitForLoadState();
		//assertThat(page).hasTitle("Amazon Sign In");
		//LoginPage.enterPassword(env.get("Amazon_pwd"));
		//LoginPage.clickOnSignin();
		LoginPage.enterOTP("123456");
		//LoginPage.clickOnSubmitCode();
			
}

}
