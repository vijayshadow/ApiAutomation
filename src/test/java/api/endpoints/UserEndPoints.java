package api.endpoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.UserPOJO;

public class UserEndPoints {

	public static Response createUser(UserPOJO payload) {
		Response response = given()					
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(payload)
					.when()
						.post(Routes.POST_URL);
		return response;

	}

	public static Response readUser(String username) {
		Response response = given()
					.contentType(ContentType.JSON)
					.pathParam("username", username)
				.when()
					.get(Routes.GET_URL);

		return response;

	}

	public static Response updateUser(String username, UserPOJO payload) {
		/*
		 * curl -X 'GET' \ 'https://reqres.in/api/users/,' \ -H 'accept:
		 * application/json'
		 */

		Response response = given()
					.contentType(ContentType.JSON)
					.pathParam("userid", username)
					.body(payload)
				.when()
					.put(Routes.PUT_URL);

		return response;

	}

	public static Response deleteUser(String username) {
		/*
		 * curl -X 'GET' \ 'https://reqres.in/api/users/,' \ -H 'accept:
		 * application/json'
		 */

		Response response = given().pathParam("username", username).when().delete(Routes.DELETE_URL);

		return response;

	}

}
