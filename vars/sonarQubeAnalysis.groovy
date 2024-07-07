// vars/sonarQubeAnalysis.groovy
def call(String projectKey, String sourceDir = '.') {
    def scannerHome = org.example.Utilities.getScannerHome()
    withSonarQubeEnv('SonarQube') {
        org.example.Utilities.runSonarScanner(scannerHome, projectKey, sourceDir, 'http://localhost:9000', env.SONARQUBE_TOKEN)
    }
}
