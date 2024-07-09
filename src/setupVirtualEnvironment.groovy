def call() {
    // Your setup steps here
    sh '''
        python3 -m venv myenv
        . myenv/bin/activate
    '''
}
