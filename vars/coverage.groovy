import setupVirtualEnvironment

def call() {
    setupVirtualEnvironment()
    
    // Additional steps after setting up the environment
    sh '''
        pip install -r requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    '''
}
