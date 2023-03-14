package week3.day2.assignments;





import org.testng.annotations.Test;



public class DeleteIssue extends BaseClass{
	
	@Test(dependsOnMethods = "week3.day2.assignments.UpdateIssue.updateJiraIssue")
	public void deleteJiraIssue() {
		
		
		response = request
								
								.delete("issue/"+issue_id);
		response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
		
	}

}
