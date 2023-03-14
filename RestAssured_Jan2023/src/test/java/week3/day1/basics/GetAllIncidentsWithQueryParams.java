package week3.day1.basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentsWithQueryParams {
	
	@Test
	public void getAllIncidentsWithParams() {
		
//		1. Requirements
		
		
//		2. End point with resources
		
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		
//		3. Construct the request
		
		RequestSpecification inputRequest = RestAssured
											.given()
											.queryParam("sysparm_fields", "number,sys_id,category")
										
											;
		
//		4. Send the request
	
		Response response = inputRequest.get();
//		5. Validate the response
		response.prettyPrint();
		
	}

}
