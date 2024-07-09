def call() {
    def workspaceDir = "${WORKSPACE}"
    echo "Current directory: ${pwd()}"
    echo "Workspace directory: ${workspaceDir}"
    sh """
        ls -la ${workspaceDir}
        python3 -m venv myenv
        . myenv/bin/activate
        echo "Workspace directory: ${workspaceDir}"
        pip install -r ${workspaceDir}/requirments.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    """
}
