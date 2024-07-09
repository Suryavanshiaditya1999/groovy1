def call() {
    def python = tool name: 'Python3', type: 'hudson.plugins.python.PythonInstallation'
    
    // Define steps for setting up virtual environment
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
