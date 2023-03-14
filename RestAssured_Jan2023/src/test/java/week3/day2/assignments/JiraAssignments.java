package week3.day2.assignments;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JiraAssignments extends BaseClass{
	
	@Test
	public void getAllIssues24Hours() {
		response = request
						.given()
							.queryParam("jql", "project=May and created>-24h")
							.get("search");

				
		response.then().assertThat()
							.statusCode(200)
							.time(Matchers.lessThan(7000L))
							.body("issues[0].key", Matchers.containsString("MAY"))
							.body("issues[0].key.size()", Matchers.is(8));
//		issues.size()
		
		//status code, response time, verify the key contains the string May 
		//and make sure the length of the issue key is 7  
	}
	
	@Test
	private void randomUpdate() {
//		response = request.given().get();
//		String key = (String) response.jsonPath().getList("issues.key").get(0);
		
		response = request.given()
							.body("{\r\n"
									+ "    \"fields\": {\r\n"
									+ "        \"project\": { \"key\": \"MAY\" },\r\n"
									+ "        \"description\": \"Updated via Rest-Assureda\",\r\n"
									+ "        \"issuetype\": { \"name\": \"Task\" }\r\n"
									+ "    }\r\n"
									+ "}")
							.put("issue/MAY-523");
		//response.prettyPrint();
		//status code, status line, empty response body check and content type is json
		response.then().assertThat()
							.statusCode(204).and()
							.statusLine("HTTP/1.1 204 No Content")
//		response.prettyPrint();
							.and()
							.body(Matchers.blankOrNullString())
							.and()
							.contentType(ContentType.JSON);

	}

}
