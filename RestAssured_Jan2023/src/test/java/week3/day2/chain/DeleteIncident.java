package week3.day2.chain;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteIncident extends BaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.chain.CreateIncident.createIncidentTest"})
	public void deleteIncidentTest() {
		response = request.delete("incident/"+sys_id);
		response.then().assertThat().statusCode(204);
	}

}
