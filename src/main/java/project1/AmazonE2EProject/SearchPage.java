package project1.AmazonE2EProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SearchPage 
{
	Page page;
	private Locator searchDropBox;
	private Locator searchButton;	
	private Locator productInformation;
	private Locator priceRangeTablet;
	private Locator searchNextPage;
	private Locator selectNthTablet;
	
	public SearchPage(Page page)
	{
		this.page=page;
		searchDropBox = page.locator("#searchDropdownBox");
		searchButton = page.locator("#nav-search-submit-button");
		productInformation = page.locator("#prodDetails");
		priceRangeTablet = page.locator("//span[text()='₹100,000 - ₹170,000']");
		searchNextPage = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next"));
		selectNthTablet =page.locator("div[class='a-section aok-relative s-image-square-aspect']");
		
		}
	
	public void clickOnSearchDropBox()
	{
		searchDropBox.click();
		searchDropBox.selectOption("Computers & Accessories");
	}
	
	public void clickOnSearchBotton()
	{
		searchButton.click();
	}
	public void selectPriceRangeTablet()
	{
		priceRangeTablet.click();
	}
	public void clickOnSearchNextPage()
	{
		searchNextPage.click();
	}
	public void selectNthTablet()
	{
		selectNthTablet.nth(3).click();
	}
}
