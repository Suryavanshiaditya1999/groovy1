def call() {
    sh '''
       python3 -m venv myenv
       . myenv/bin/activate
       snyk test --file=poetry.lock
    '''
}
