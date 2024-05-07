package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.UserPOJO;
import api.utility.DataProviders;
import io.restassured.response.Response;

public class DataDriven {
	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)	
	public void testPostUser(String userid,String username, String firstname, String lastname,String email,String password,String phnumber){
		UserPOJO userpayload = new UserPOJO();
		userpayload.setId(Integer.parseInt(userid));
		userpayload.setUsername(username);
		userpayload.setFirstName(firstname);
		userpayload.setLastName(lastname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phnumber);
		
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=1,dataProvider="UserNames",dataProviderClass=DataProviders.class)	
	public void testDeleteUser(String username){
		
		Response response = UserEndPoints.deleteUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
