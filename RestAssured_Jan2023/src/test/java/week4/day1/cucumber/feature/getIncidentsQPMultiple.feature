Feature: ServiceNow Incident Managment

Scenario: Get all the Incidents with Query Parameters
Given set the endpoint
And add the auth
And add the queryparams
|sysparm_fields|sys_id,number,category|
|category|software|
When send the request
Then validate the response