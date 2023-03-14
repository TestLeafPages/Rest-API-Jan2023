package week3.day2.assignments;


import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;



public class UpdateIssue extends BaseClass{
	
	@Test(dependsOnMethods = "week3.day2.assignments.CreateIssue.createJiraIssue")
	public void updateJiraIssue() {
		
		File file = new File("./src/test/resources/updateIssueJira.json");
		response = request
								.body(file)
								.put("issue/"+issue_id);
		response.then().assertThat().body(Matchers.blankOrNullString());
		
	}

}
