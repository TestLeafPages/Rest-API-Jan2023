package week4.day1.assignments;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;



public class GetIssue extends BaseClass{
	
	@Test(dependsOnMethods = "week4.day1.assignments.DeleteIssue.deleteJiraIssue")
	public void getJiraIssue() {
		
		
		response = request
							
								.get("issue/"+issue_id);
		response.prettyPrint();
		response.then().assertThat()
			.statusLine("HTTP/1.1 404 Not Found").and()
			.body("errorMessages[0]", Matchers.equalTo("Issue does not exist or you do not have permission to see it."));
		
	}

}
