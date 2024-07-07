package org.example

class Utilities {
    static String getScannerHome() {
        return tool name: 'SonarQube-Scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    }

    static void runSonarScanner(String scannerHome, String projectKey, String sourceDir, String sonarHostUrl, String sonarToken) {
        sh "${scannerHome}/bin/sonar-scanner " +
           "-Dsonar.projectKey=${projectKey} " +
           "-Dsonar.sources=${sourceDir} " +
           "-Dsonar.host.url=${sonarHostUrl} " +
           "-Dsonar.login=${sonarToken}"
    }
}
