package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.ConfigReader;
import io.github.cdimascio.dotenv.Dotenv;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase1_NewUserRegistrationSuccessful extends BaseTest
{
	

	@Test(retryAnalyzer=RetryLogic.class)
	public void newUserRegistartionSuccess() 
	{
		HomePage HomePage = new HomePage(page);
		HomePage.hoverOverOnAccountAndList();
		HomePage.clickonNewCustomerStartHere();
		
		LoginPage LoginPage = new LoginPage(page);
		LoginPage.enterUsername(ConfigReader.get("Amazon_un1"));
		LoginPage.clickOnContinue();
		
		assertThat(page).hasTitle("Sign in");
		//assertThat(locator)HomePage.
		
		LoginPage.clickOnCreateAccount();
		assertThat(page).hasTitle("Amazon Registration");
		//LoginPage.enterMobileNo(ConfigReader.get("Amazon_mobilenumber"));//Loading .env from confi reader
		
		Dotenv env= Dotenv.load();
		//String MobileNo= env.get("Amazon_mobilenumber");
		LoginPage.enterMobileNo(env.get("Amazon_mobilenumber"));
		
		LoginPage.enterNameForRegistration();
		LoginPage.verifyMobileNumber();
		//assertThat(page).hasTitle("Authentication required");
		
		
	}

}
