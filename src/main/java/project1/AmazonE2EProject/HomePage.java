package project1.AmazonE2EProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage 
{	Page page;
	private Locator accountAndList;
	private Locator signin;
	private Locator newCustomerStart;
	private Locator yourAccount;
	
	//create constructor to invoke its method
	
	public HomePage(Page page)
	{
		// It should have page, as all page related activities performed here
		this.page=page; // assigning Local variable value to global variable
		accountAndList= page.getByText("Account & Lists", new Page.GetByTextOptions().setExact(true));
		signin= page.locator("#nav-flyout-ya-signin");
		//newCustomerStart= page.getByText("Start here.", new Page.GetByTextOptions().setExact(true));
		newCustomerStart= page.getByLabel("New to Amazon? Start here to create an account");
		//yourAccount= page.locator("//div[@id='nav-al-your-account']//ul//li[3]/a");
		yourAccount= page.locator("((//div[@id='nav-al-your-account'])/child::ul)/child::li[3]");
	}
	
	public void hoverOverOnAccountAndList()
	{
		// here we need to perform action
		accountAndList.hover();
	}
	
	public void clickOnSignin()
	{
		// here we need to perform action
		signin.click();
	}
	
	public void clickonNewCustomerStartHere()
	{
		newCustomerStart.click();
	}
	public void clickonYourAccount()
	{
		yourAccount.click();
	}
}
