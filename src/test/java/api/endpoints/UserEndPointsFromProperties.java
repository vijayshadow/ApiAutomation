package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.UserPOJO;

public class UserEndPointsFromProperties {
/*
 * Load Routes Properties file 
 */
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response createUser(UserPOJO payload) {
		String post_url = getURL().getString("post_url");
		Response response = given()					
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(payload)
					.when()
						.post(post_url);
		return response;

	}

	public static Response readUser(String username) {
		String get_url = getURL().getString("GET_URL");
		Response response = given()
					.contentType(ContentType.JSON)
					.pathParam("username", username)
				.when()
					.get(get_url);

		return response;

	}

	public static Response updateUser(String username, UserPOJO payload) {
		/*
		 * curl -X 'GET' \ 'https://reqres.in/api/users/,' \ -H 'accept:
		 * application/json'
		 */
		String put_url = getURL().getString("PUT_URL");
		Response response = given()
					.contentType(ContentType.JSON)
					.pathParam("userid", username)
					.body(payload)
				.when()
					.put(put_url);

		return response;

	}

	public static Response deleteUser(String username) {
		/*
		 * curl -X 'GET' \ 'https://reqres.in/api/users/,' \ -H 'accept:
		 * application/json'
		 */
		String delete_url = getURL().getString("DELETE_URL");
		Response response = given()
						.pathParam("username", username)
						.when()
						.delete(delete_url);
		return response;

	}

}
