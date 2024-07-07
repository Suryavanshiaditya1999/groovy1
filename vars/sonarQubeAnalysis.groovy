import SonarQube 

def call(String projectKey, String sourcesDir, String sonarToken) {
    new SonarQube().call(projectKey, sourcesDir, sonarToken)
}
