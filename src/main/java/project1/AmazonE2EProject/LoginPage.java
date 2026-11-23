package project1.AmazonE2EProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage 
{	
	Page page;
	private Locator username;
	private Locator continuebutton;
	private Locator password;
	private Locator signin;
	private Locator createaccount;
	private Locator mobileno;
	private Locator entername;
	private Locator verifymobilenumber;
	private Locator otpSubmitbox;
	private Locator searchBox;
	private Locator submitCode;
	public LoginPage(Page page)
	{
		this.page=page;
		username= page.locator("#ap_email_login");
		continuebutton= page.locator("//input[@class='a-button-input']");
		password= page.locator("#ap_password");
		signin= page.locator("#signInSubmit");
		//createaccount= page.getByText("Proceed to create an account", new Page.GetByTextOptions().setExact(true));
		//createaccount= page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to create an account"));
		createaccount= page.locator("//input[@class='a-button-input']");
		mobileno= page.getByPlaceholder("Mobile number");
		entername= page.getByPlaceholder("First and last name");
		verifymobilenumber= page.locator("//input[@class='a-button-input']");
		otpSubmitbox= page.locator("#input-box-otp");
		searchBox= page.locator("input[id^='two']");//CSS with partial Attribute value search
		submitCode=page.locator("//span[text()='Submit code']");
	}
	public void enterUsername(String UN)
	{
		username.fill(UN);
	}
	public void clickOnContinue()
	{
		continuebutton.click();
	}
	public void enterPassword(String PWD)
	{
		password.fill(PWD);
	}
	public void clickOnSignin()
	{
		signin.click();
	}

	
	public void enterOTP(String	OTP ) 
	  
	  { 
		  otpSubmitbox.fill(OTP); 
	  }
	 
	public void clickOnCreateAccount()
	{
		createaccount.click();
	}
	public void enterMobileNo(String Mobile_No)
	{
		mobileno.fill(Mobile_No);
	}
	public void enterNameForRegistration()
	{
		entername.fill("Sam");
	}
	public void verifyMobileNumber()
	{
		verifymobilenumber.click();
	}
	public void clickOnSearchBox(String value)
	{
		//searchBox.click();
		searchBox.fill(value);
		searchBox.press("Enter");
	}
	public void clickOnSubmitCode()
	{
		submitCode.click();
	}
}

