package week3.day2.basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentwithBodyAsString {
	
	@Test
	public void getIncidents() {
//		- Requirements
		
//		- End point
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		
		RequestSpecification request = RestAssured.
										given()
										.contentType(ContentType.JSON)
										.body("{\"short_description\":\"from Rest assured\",\"category\":\"software\"}");
		
//		- Send Request-Get,Post etc
		Response response = request.post();
		
		System.out.println(response.statusCode());
		
		response.prettyPrint();
//		- Validate the Response
	}

}
