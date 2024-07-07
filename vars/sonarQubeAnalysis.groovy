def call(String projectKey, String sourcesDir, String sonarToken) {
    new src.SonarQube().call(projectKey, sourcesDir, sonarToken)
}
