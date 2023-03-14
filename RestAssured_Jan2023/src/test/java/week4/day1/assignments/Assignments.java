package week4.day1.assignments;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignments {
	
	static RequestSpecification request=null;
	static Response response = null;
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		
	}
	
	@Test
	public void update() {
		String sys_id = "1c741bd70b2322007518478d83673af3";
		 request = RestAssured.given().contentType(ContentType.JSON).body("");
		 request.put(sys_id).prettyPrint();
		 
		 
		
	}
	

}
