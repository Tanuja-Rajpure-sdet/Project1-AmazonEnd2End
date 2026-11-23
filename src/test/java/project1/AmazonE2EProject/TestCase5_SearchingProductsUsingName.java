package project1.AmazonE2EProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.cdimascio.dotenv.Dotenv;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)
public class TestCase5_SearchingProductsUsingName extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void searchProductUsingName() throws EncryptedDocumentException, IOException
	{
		HomePage HomePage = new HomePage(page);
		HomePage.hoverOverOnAccountAndList();
		HomePage.clickOnSignin();
		Reporter.log("Successfully navigated through Amazon home page.");
		LoginPage LoginPage = new LoginPage(page);
		Dotenv env= Dotenv.load();
		LoginPage.enterUsername(env.get("Amazon_un"));
		LoginPage.clickOnContinue();
		LoginPage.enterPassword(env.get("Amazon_pwd"));
		LoginPage.clickOnSignin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Reporter.log("User Successfully logged in Amazon.in.");
		//Get input from excel sheet
		FileInputStream file= new FileInputStream("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmazonE2EProject\\test-output\\ExcelSheet\\AmazonE2ETestData.xlsx");
		Workbook workbook=WorkbookFactory.create(file);
		String value= workbook.getSheet("product").getRow(0).getCell(0).getStringCellValue();
		LoginPage.clickOnSearchBox(value);
		assertThat(page).hasTitle("Amazon.in : shoe");
		
		
	}

}
