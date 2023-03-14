package week4.day1.assignments;





import org.testng.annotations.Test;



public class DeleteIssue extends BaseClass{
	
	@Test(dependsOnMethods = "week4.day1.assignments.UpdateIssue.updateJiraIssue")
	public void deleteJiraIssue() {
		
		
		response = request
								
								.delete("issue/"+issue_id);
		response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
		
	}

}
