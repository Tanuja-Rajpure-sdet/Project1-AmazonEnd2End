package project1.AmazonE2EProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class YourAccountPage 
{
	Page page;
	private Locator loginAndSecurity1;
	private Locator editEmail;
	private Locator submitCode;
	 Locator newName;
	private Locator saveChanges;
	private Locator accountSettings;
	
	public YourAccountPage(Page page)
	{
		this.page=page;
		//loginAndSecurity= page.getByText("Login & security");
		editEmail= page.locator("#auth-cnep-edit-name-button");
		submitCode= page.locator("#cvf-submit-otp-button-announce");
		newName= page.locator("input[name='customerName']");
		saveChanges= page.locator(".a-button-input");
		//accountSettings=page.locator("//span[text()='Account settings']");-StrictModeViolatio
		//accountSettings= page.getByTestId("heading-section-1-expanded").getByText("Account settings");
		//accountSettings=page.getByTestId("heading-section-1-expander");
		accountSettings=page.locator("(//button[@aria-label=\"Account settings, collapsed\"]/child::div)//span[text()='Account settings']");
		loginAndSecurity1 = page.locator("//span[text()='Login and security']");
	}
	public void clickOnAccountSettingsDropDown()
	{
		accountSettings.click();
	}
	
	public void clickOnLoginAndSecurity()
	{
		loginAndSecurity1.click();
	}
	public void clickOnEditEmailbutton()
	{
		editEmail.click();
	}
	public void clickOnsubmitCode()
	{
		submitCode.click();
	}
	public void clickOnNewName()
	{
		newName.click();
	}
	public void clickOnSaveChanges()
	{
		saveChanges.check();
	}
}
