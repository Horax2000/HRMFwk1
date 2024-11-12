package org.HRMFwk.Integrations;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraIntegration {
    private String jiraUrl;
    private String username;
    private String apiToken;

    public JiraIntegration(String jiraUrl, String username, String apiToken) {
        this.jiraUrl = jiraUrl;
        this.username = username;
        this.apiToken = apiToken;
    }

    public void uploadTestResult(String testCaseId, String result) {
        String payload = String.format("{\"fields\": {\"customfield_10000\": \"%s\"}}", result);
        Response response = RestAssured.given()
                .auth()
                .preemptive()
                .basic(username, apiToken)
                .header("Content-Type", "application/json")
                .body(payload)
                .post(jiraUrl + "/rest/api/2/issue/" + testCaseId);

        System.out.println("Uploaded test result: " + response.getStatusCode());
    }

    public void createDefect(String defectSummary, String defectDescription) {
        String payload = String.format("{\"fields\": {\"summary\": \"%s\", \"description\": \"%s\", \"issuetype\": {\"name\": \"Bug\"}}}", defectSummary, defectDescription);
        Response response = RestAssured.given()
                .auth()
                .preemptive()
                .basic(username, apiToken)
                .header("Content-Type", "application/json")
                .body(payload)
                .post(jiraUrl + "/rest/api/2/issue");

        System.out.println("Created defect: " + response.getStatusCode());
    }
}