package week4.day1.staticImports;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StaticImportTest {
	
	
	@Test(enabled=true)
	public void staticTest() {
		baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		authentication = basic("admin", "nloB*^2PcRM1");
		Response response = get();
		response.then().assertThat().statusCode(200).body("result[0].number", containsString("INC"));
	}
	@Test(enabled =true)
	public void withoutStaticTest() {
		
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
		Response response = RestAssured.get();
		response.prettyPrint();
		response.then().assertThat().statusCode(200).body("result[0].number", Matchers.containsString("INC"));
		
	}
	

}
