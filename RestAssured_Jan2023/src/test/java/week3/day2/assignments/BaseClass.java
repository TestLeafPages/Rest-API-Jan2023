package week3.day2.assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	static RequestSpecification request=null;
	static Response response = null;
	static String issue_id = null;
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://testleafjune2022.atlassian.net/rest/api/2/";
		RestAssured.authentication = RestAssured.preemptive().basic("testleafjune2022@gmail.com", "utmqLuSFJKsHY012OOVgCE8F");
		
		request = RestAssured
				.given()
				.contentType(ContentType.JSON)
					.log()
					.all();
	}
	
	@AfterMethod
	public void tearDown() {
		//response.then().log().all();
		System.out.println("Status Code => "+response.statusCode());

	}

}
