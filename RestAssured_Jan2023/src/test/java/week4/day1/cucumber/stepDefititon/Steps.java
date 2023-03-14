package week4.day1.cucumber.stepDefititon;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {
	
	RequestSpecification request = null;
	Response response = null;
	
	@Given("set the endpoint")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev75350.service-now.com/api/now/table/incident";
	}
	
	@And("add the auth")
	public void addAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "nloB*^2PcRM1");
	}
	
	@When("send the request")
	public void sendRequest() {
	
		//request = RestAssured.given().log().all();
		response = request.get();
	}
	
	@Then("validate the response")
	public void validateResponse() {
		response.then().log().all().assertThat().statusCode(200);
	}
	
	@And("add the queryparams as {string} and {string}")
	public void addQueryParams(String key, String value) {
		request = RestAssured.given().log().all();
		request.queryParam(key, value);
		
	}
	
	@And("add the queryparams")
	public void addQueryParams(DataTable dt) {
		request = RestAssured.given().log().all();
		Map<String,String> asMap = dt.asMap();
		request.queryParams(asMap);
		
	}

}
