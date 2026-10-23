def call(String testDir = 'tests', String appDir = 'app') {
    echo "Installing dependencies and running pytest inside Docker container..."

    sh """
        python3 -m venv .venv
        . .venv/bin/activate
        pip install --upgrade pip
        pip install -r requirements.txt

        export PYTHONPATH="\$WORKSPACE/1-python-app-repo"
        pytest ${testDir} \
            --junitxml=test-results.xml \
            --cov=${appDir} \
            --cov-report=xml:coverage.xml \
            -v
    """
}