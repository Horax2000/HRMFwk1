package org.HRMFwk.Setup;

public enum Config {
    BASE_URL("https://opensource-demo.orangehrmlive.com/web/index.php"),
    TIMEOUT("30"),
    BROWSER("chrome"),
    DB_URL("jdbc:mysql://localhost:3306/yourdatabase"),
    DB_USERNAME("username"),
    DB_PASSWORD("password"),
    API_KEY("your_api_key"),
    REPORT_PATH("reports/ExtentReport.html"),
    EXECUTION_SUITE_PATH("path/to/execution/suite.json"),
    JIRA_URL("https://your-jira-instance.com"),
    JIRA_USERNAME("username"),
    JIRA_API_TOKEN("api_token");

    private final String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
