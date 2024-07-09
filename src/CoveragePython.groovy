def call() {
    sh '''
        git clone https://github.com/Suryavanshiaditya1999/attendace.git
        cd attendace
        python3 -m venv myenv
        . myenv/bin/activate
        echo "Workspace directory: ${WORKSPACE}/requirments.txt"
        pip install -r ${WORKSPACE}/requirements.txt
        pip install coverage
        pip install pytest
        coverage run -m pytest
        coverage report -m
    '''
}
