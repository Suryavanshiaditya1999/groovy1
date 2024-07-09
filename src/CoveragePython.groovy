def call() {
    sh '''
        python3 -m venv myenv
        . myenv/bin/activate
        echo "Workspace directory: ${WORKSPACE}/requirments.txt"
        pip install -r ${WORKSPACE}/resources/requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    '''
}
