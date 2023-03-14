package week3.day1.basics;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentsWithQueryParamsMultiple {
	
	@Test
	public void getAllIncidentsWithParams() {
		
//		1. Requirements
		
		
//		2. End point with resources
		
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		
//		3. Construct the request
		
		Map<String,String> queryMap = new HashMap<String,String>();	
		queryMap.put("sysparm_fields", "number,sys_id,category");
		queryMap.put("category", "software");
		
		RequestSpecification inputRequest = RestAssured
											.given()
											.queryParams(queryMap)
										    
											;
		
//		4. Send the request
	
		Response response = inputRequest.get();
//		5. Validate the response
		response.prettyPrint();
		
	}

}
