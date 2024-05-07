package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.github.javafaker.Faker;

//import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPointsFromProperties;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTestRoutesPropertie {

	Faker faker;
	UserPOJO userpayload;
	
	@BeforeClass
	public void setupfakedata() {
		faker = new Faker();
		userpayload = new UserPOJO();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 8));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void testPostUser() {
		Response response = UserEndPointsFromProperties.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2)
	
	  public void testGetUser() {
		Response response =UserEndPointsFromProperties.readUser(this.userpayload.getUsername()); 
		response.then().log().all();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
	  }
	 
}