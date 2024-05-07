package api.endpoints;


/* crud - Create, read, update, delete*/
//GET -	https://reqres.in/api/users?page=2
//GET -	https://reqres.in/api/users/2
			
//POST -	https://reqres.in/api/users
//PUT -		https://reqres.in/api/users/2
//DELETE -	https://reqres.in/api/users/2	



public class Routes {
 public static String BASE_URL ="https://petstore.swagger.io/v2";
 public static String POST_URL =BASE_URL+"/user";
 public static String GET_URL =BASE_URL+"/user/{username}";
 public static String PUT_URL =BASE_URL+"/user/{username}";
 public static String DELETE_URL =BASE_URL+"/user/{username}";
	
	
}
