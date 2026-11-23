package project1.AmazonE2EProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage 
{
	Page page;
	private Locator selectCategoryLaptop;
	private Locator selectCategoryTablet;
	private Locator selectPriceRange;
	private Locator selectFirstTablet;
	private Locator appleBrandCheckBox;
	private Locator productTitle;
	private Locator productPrice;
	private Locator buttonAddToCart;
	private Locator addedToCart;
	
	public ProductPage(Page page)
	{
		this.page=page;
		selectCategoryTablet = page.getByLabel("Category").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Tablets"));
		selectCategoryLaptop= page.getByLabel("Category").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Laptops"));
		selectPriceRange = page.locator("//span[text()='₹20,000 – ₹30,000']");
		selectFirstTablet = page.locator(".a-cardui").first();
		appleBrandCheckBox = page.locator("(//span[text()='Apple']/preceding-sibling::div/label/i)[1]");
		productTitle = page.locator("//span[@id='productTitle']");
		productPrice = page.locator("#tp_price_block_total_price_ww");
		buttonAddToCart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
		
		//addedToCart = page.getByText(" Added to cart ", new Page.GetByTextOptions().setExact(true));
		addedToCart = page.locator("span[class='a-size-medium a-text-bold']").getByText(" Added to cart ");
	}
	public void clickOnCategoryLaptop()
	{
		selectCategoryLaptop.click();
	}
	public void clickOnCategoryTablet()
	{
		selectCategoryTablet.click();
	}
	public void selectPriceRange()
	{
		selectPriceRange.click();
	}
	public void selectFirstTablet()
	{
		selectFirstTablet.click();
	}
	public void checkAppleBrandCheckBox()
	{
		appleBrandCheckBox.check();
	}
	public void verifyproductTitle()
	{
		assertThat(productTitle).isVisible();
	}
	public void verifyProductPrice()
	{
		assertThat(productPrice).isVisible();
	}
	public void addToCart()
	{
		buttonAddToCart.click();
	}
	public void verifyProductAddedToCart()
	{
		assertThat(addedToCart).isVisible();
	}
}
