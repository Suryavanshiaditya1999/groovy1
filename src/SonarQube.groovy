def call(String projectKey, String sourcesDir, String sonarToken) {
    def scannerHome = tool name: 'SonarQube-Scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    withSonarQubeEnv('SonarQube') {
        sh "${scannerHome}/bin/sonar-scanner " +
           "-Dsonar.projectKey=${projectKey} " +
           "-Dsonar.sources=${sourcesDir} " +
           "-Dsonar.host.url=http://localhost:9000 " +
           "-Dsonar.login=${sonarToken}"
    }
}
