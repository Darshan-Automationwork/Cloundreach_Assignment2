package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import utils.PropertyFileUtils;
import utils.RestassuredUtils;

public class AcceptanceTest {
	
	String base_uri;
	PropertyFileUtils propertyFileUtils=new PropertyFileUtils();
	RestassuredUtils restAssuredUtils=new RestassuredUtils();

	public AcceptanceTest()
	{
	this.base_uri=propertyFileUtils.getPropertyValue("config.properties", "baseURL");
	}
	@Test(priority = 1,description = "Register a user successfully")
	public void registerUserSuccessfully()
	{
	Map<String ,Object> headers=new HashMap<String, Object>();
	headers.put("content-Type", "application/json");
	String email = "abhimanyu.raj@reqres.in";
	   String password ="password";
	   String body = "{\"username\":" + "\"" + email + "\"" + ",\"password\":" + "\"" + password + "\"" + "}";
	   System.out.println(restAssuredUtils.postRequest(headers,body,"https://reqres.in/api/register").getBody().asString()+"executed");
	}
}
