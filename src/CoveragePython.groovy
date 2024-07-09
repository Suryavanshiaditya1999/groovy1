def call() {
    def workspaceDir = "${WORKSPACE}"
    echo "Current directory: ${pwd()}"
    echo "Workspace directory: ${workspaceDir}"

    // Set up Python virtual environment
    setupVirtualEnvironment(workspaceDir)

    // Install Python dependencies
    installPythonDependencies(workspaceDir)

    // Run tests with coverage
    runTests()
}

def setupVirtualEnvironment(workspaceDir) {
    sh """
        echo "Setting up Python virtual environment"
        python3 -m venv ${workspaceDir}/myenv
        source ${workspaceDir}/myenv/bin/activate
    """
}

def installPythonDependencies(workspaceDir) {
    def requirementsFile = "${workspaceDir}/requirements.txt"
    if (fileExists(requirementsFile)) {
        sh """
            echo "Installing Python dependencies from ${requirementsFile}"
            pip install -r ${requirementsFile}
            pip install coverage pytest
        """
    } else {
        error "Requirements file not found: ${requirementsFile}"
    }
}

def runTests() {
    sh """
        echo "Running tests with coverage"
        coverage run -m pytest
        coverage report -m
    """
}

boolean fileExists(String filePath) {
    return sh(script: "[ -e ${filePath} ]", returnStatus: true) == 0
}
