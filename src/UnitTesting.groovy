def call() {
    def workspaceDir = "${WORKSPACE}"
    echo "Current directory: ${pwd()}"
    echo "Workspace directory: ${workspaceDir}"
    sh """
        ls -la ${workspaceDir}
        python3 -m venv myenv
        . myenv/bin/activate
        echo "Workspace directory: ${workspaceDir}"
        pip install pytest
        pip install pytest-html
        pip install -r ${workspaceDir}/requirments.txt
        python3 -m pytest --continue-on-collection-errors --maxfail=5 --html=report.html
    """
}
