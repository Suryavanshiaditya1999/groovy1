def call() {
    sh '''
        python3 -m venv myenv
        . myenv/bin/activate
        pip install -r ${WORKSPACE}/requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    '''
}
