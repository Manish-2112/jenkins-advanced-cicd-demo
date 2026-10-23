// File: vars/logStageBanner.groovy
// Usage in Jenkinsfile: logStageBanner('STAGE TITLE')

def call(String stageTitle) {
    echo "============================================================"
    echo ">>> STAGE: ${stageTitle}"
    echo ">>> JOB: ${env.JOB_NAME} | BUILD: #${env.BUILD_NUMBER}"
    echo "============================================================"
}
