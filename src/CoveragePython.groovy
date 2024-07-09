// vars/setupVirtualEnvironment.groovy

def call() {
    node {
        stage('Set Up Virtual Environment') {
            checkout scm

            // Set up virtual environment
            def pythonHome = tool name: 'Python', type: 'hudson.plugins.python.PythonInstallation'
            def pipHome = tool name: 'Python', type: 'hudson.plugins.python.PythonInstallation'
            env.PYTHON_HOME = pythonHome
            env.PATH = "${env.PYTHON_HOME}/bin:${env.PATH}"
            sh 'python3 -m venv myenv'
            sh '. myenv/bin/activate'
            
            // Install dependencies
            sh 'pip install -r requirements.txt'
            sh 'pip install coverage'
            sh 'pip install pytest'

            // Run tests
            sh 'coverage run -m pytest'
            sh 'coverage report -m'
        }
    }
}
