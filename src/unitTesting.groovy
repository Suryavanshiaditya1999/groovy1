def call() {
    sh '''
        python3 -m venv venv
        . venv/bin/activate
        pip install pytest
        pip install pytest-html
        pip install -r requirements.txt
        python3 -m pytest --continue-on-collection-errors --maxfail=5 --html=report.html
    '''
}
