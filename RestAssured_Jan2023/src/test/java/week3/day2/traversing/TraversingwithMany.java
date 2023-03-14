package week3.day2.traversing;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TraversingwithMany {

	@Test
	public void CreateIncident() {

		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		
		RequestSpecification request = RestAssured
										.given()
										.contentType(ContentType.JSON);
										

		Response response = request.get();
		
		List<String> list = response.jsonPath().getList("result.sys_id");
		System.out.println("Count of Sys_id = " + list.size());
		System.out.println(response.jsonPath().get("result[0].sys_id"));
//		
		
		

		//response.prettyPrint();
//		System.out.println(response.statusCode());

	}

}
