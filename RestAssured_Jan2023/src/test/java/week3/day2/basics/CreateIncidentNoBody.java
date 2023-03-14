package week3.day2.basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentNoBody {
	
	@Test
	public void CreateIncident() {
//		- Requirements
		
			RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		
		RequestSpecification request = RestAssured.
										given()
										.contentType(ContentType.JSON);
		
//		- Send Request-Get,Post etc
		Response response = request.post();
		
		
		
		response.prettyPrint();
		System.out.println("Respone code="+response.getStatusCode());
//		- Validate the Response
	}

}
