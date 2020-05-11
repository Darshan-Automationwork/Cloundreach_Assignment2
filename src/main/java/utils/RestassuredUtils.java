package utils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestassuredUtils {
	/**
	 * Restassured Utils /** The below method is used fOR POST call
	 *
	 * @param header-Header
	 * @param body-Body     in String format
	 * @param uri-
	 * @return
	 */
	public Response postRequest(Map<String, Object> header, String body, String uri) {
		try {
			return RestAssured.given().headers(header).body(body).when().contentType("application/json").post(uri);
		} catch (Exception e) {

			System.out.println(
					"User is getting following error" + e.getMessage() + "while making post Request to this " + uri);
			return null;
		}
	}

	/**
	 * This method is used to make a get Request
	 *
	 * @param logger
	 * @param header
	 * @param uri
	 * @return
	 */
	public Response getRequest(Map<String, String> header, String uri) {
		try {
			return RestAssured.given().headers(header).when().contentType("application/json").get(uri);
		} catch (Exception e) {
			System.out.println("user is getting following error" + e.getMessage() + "while making get Request");
			return null;
		}
	}

}
