package week3.day2.assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnAssertions {
	//1. Verify the Status Code
	@Test
	private void statusCodeCheck() {
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		Response response = RestAssured.get();
		response.then().assertThat().statusCode(207);
}
	//2. Verify the incident number is present in the response - INC0000009
	@Test
	private void incidentNumberCheck() {
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		Response response = RestAssured.get();
		response.then().assertThat().body("result.number", Matchers.hasItem("INC0010030"));
}
	//3. Verify the string "INC" is present in the response (number) using post
	@Test
	private void containsVerification() {
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		Response response = RestAssured
									.given().contentType(ContentType.JSON)
									.post();
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
}
	//4. Verify the incident number INC0000009 is equal to first result
	@Test
	private void equalString() {
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		Response response = RestAssured.get();
		response.then().assertThat().body("result[0].number", Matchers.equalTo("INC0000060"));

	}

}
