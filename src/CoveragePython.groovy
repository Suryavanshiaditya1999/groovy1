def call() {
    def workspaceDir = "${WORKSPACE}"
    sh """
        python3 -m venv myenv
        . myenv/bin/activate
        echo "Workspace directory: ${workspaceDir}"
        pip install -r requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    """
}
