// Assuming 'scannerHome', 'projectKey', 'sourcesDir', and 'sonarToken' are defined somewhere in your pipeline or globally.

def call() {
    def workspaceDir = "${WORKSPACE}"
    def pythonEnv = "${workspaceDir}/code-coverage-shared/myenv"

    sh """
        git clone https://github.com/Suryavanshiaditya1999/attendace.git
        cd attendace
        python3 -m venv ${pythonEnv}
        . ${pythonEnv}/bin/activate
        echo "Workspace directory: ${workspaceDir}"
        pip install -r ${workspaceDir}/code-coverage-shared/requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    """
}
