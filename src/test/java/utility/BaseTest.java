package utility;

import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

//import config.ConfigReader;
import io.github.cdimascio.dotenv.Dotenv;
public class BaseTest extends ListenersLogic{
	@Parameters("engine")
	@BeforeMethod
	public void launch(@Optional("Chrome")String nameOfSearchEngine) 
	{
		if(nameOfSearchEngine.equals("Chrome"))
		{playwright = Playwright.create();
		browser    = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir
				(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmazonE2EProject\\test-output"
						+ "\\Video\\Video"+ dateFormat)));
		
		page    	= browsercontext.newPage();
		}
		
		String URL= getEnvValue("Amazon_url");
		page.navigate(URL);
		
	}
		//page.navigate(ConfigReader.get("Amazon_url"));// url is sensitive info so get it from .env file through ConfigReaderClass
		/*
		 * Dotenv env= Dotenv.load(); String URL= env.get("Amazon_url");
		 * page.navigate(URL);
		 */
		//CHanging code as on jenkins its unable to find .env
		
		public String getEnvValue(String key) 
		{
			Dotenv env = Dotenv.configure().ignoreIfMissing().load();
			
			String value = System.getenv(key);
			if(value==null || value.isBlank())
			{
				value = env.get(key);
			}
			if (value==null || value.isBlank())
			{
				throw new RuntimeException("Environment variable not found: " + key);
			}
			return value;
		}
	
	@AfterMethod
	public void quit() 
	{
		browsercontext.close();
        browser.close();
        playwright.close();
	}
}
