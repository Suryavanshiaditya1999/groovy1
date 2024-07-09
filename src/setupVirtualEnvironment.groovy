def call() {
    // Your setup steps here
    sh '''
        python3 -m venv myenv
        . myenv/bin/activate
        pip install -r requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    '''
}
