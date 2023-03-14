package week3.day2.assignments;


import java.io.File;

import org.testng.annotations.Test;



public class CreateIssue extends BaseClass{
	
	@Test
	public void createJiraIssue() {
		
		File file = new File("./src/test/resources/CreateJiraIssue.json");
		response = request
								.body(file)
								.post("issue");
		issue_id = response.jsonPath().get("key");
		response.then().assertThat().statusCode(201);
	}

}
