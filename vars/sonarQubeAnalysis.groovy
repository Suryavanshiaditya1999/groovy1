def call() {
    def scannerHome = tool name: 'SonarQube-Scanner'
    withSonarQubeEnv('SonarQube') {
        sh """
        ${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=attendance-api \
        -Dsonar.sources=. \
        -Dsonar.host.url=http://localhost:9000 \
        -Dsonar.login=${env.SONARQUBE_TOKEN}
        """
    }
}
