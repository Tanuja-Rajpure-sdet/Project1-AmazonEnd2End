package config;
import io.github.cdimascio.dotenv.Dotenv;

public class ConfigReader 
{
	/*
	 * Dotenv env= Dotenv.load(); String url = env.get("URL"); String UN =
	 * env.get("UN"); String PWD = env.get("PWD");
	 */
	
	private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
	
	public static String get(String key)
	{
		String value = System.getenv(key);// fetching value from system imp for jenkins run
		
			if(value==null || value.isBlank()) // if true, check local .env and fetch value
			{
				value= dotenv.get(key);
			}
			
			if(value==null || value.isBlank()) // if true, means local .env key value/key not there give exception
			{
				throw new RuntimeException("Missing Configuration: " + key);
			}
		
		return value;
	}
	
	
	
}