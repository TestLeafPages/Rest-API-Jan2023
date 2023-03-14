package week3.day2.basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentsWithLogs {
	
	@Test
	public void getIncidents() {
//		- Requirements
		
//		- End point
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
				
//		- Add/construct Request - headers,queryparams,content-type,auth
		
		RequestSpecification request = RestAssured
										.given()
										.contentType(ContentType.JSON)
										
										
										.queryParam("sysparm_fields", "number,sys_id")
										.log().all()
										;
										
		
//		- Send Request-Get,Post etc
		
		Response response = request.get();
		
		response.then().log().all();
	
		
//		Response response = request.get();
		
//		
//		System.out.println(response.statusCode());
//		
//		response.prettyPrint();
//		- Validate the Response
	}

}
