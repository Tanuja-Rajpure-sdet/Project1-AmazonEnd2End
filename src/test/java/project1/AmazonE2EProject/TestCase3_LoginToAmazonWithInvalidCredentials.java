package project1.AmazonE2EProject;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import io.github.cdimascio.dotenv.Dotenv;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@Listeners(ListenersLogic.class)
public class TestCase3_LoginToAmazonWithInvalidCredentials extends BaseTest 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void loginWithInvalidCredentials()
	{
		HomePage HomePage = new HomePage(page);
		HomePage.hoverOverOnAccountAndList();
		HomePage.clickOnSignin();
		
		Dotenv env = Dotenv.load();
		
		LoginPage LoginPage  = new LoginPage(page);
		LoginPage.enterUsername(env.get("Amazon_un"));
		LoginPage.clickOnContinue();
		LoginPage.enterPassword(env.get("Amazon_pwd1"));
		LoginPage.clickOnSignin();
		Locator l1= page.getByText("Your password is incorrect", new Page.GetByTextOptions().setExact(true));
		assertThat(l1).hasText("Your password is incorrect");
		Reporter.log("Your password is incorrect");
	}

}
