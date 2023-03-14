Feature: ServiceNow Incident Managment

Scenario: Get all the Incidents with Query Parameters
Given set the endpoint
And add the auth
And add the queryparams as "sysparm_fields" and "sys_id,number"
When send the request
Then validate the response