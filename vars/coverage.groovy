import src.setupVirtualEnvironment

def call() {
    setupVirtualEnvironment()

    // Add your remaining steps here, such as installing dependencies and running tests
    sh '''
        pip install -r requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    '''
}
