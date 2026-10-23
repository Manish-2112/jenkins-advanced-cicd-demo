// File: vars/sendBuildEmail.groovy
// Usage in Jenkinsfile: sendBuildEmail('SUCCESS', 'user@example.com')

def call(String buildStatus, String recipientEmail) {
    def icon = (buildStatus == 'SUCCESS') ? '✅' : '❌'
    def color = (buildStatus == 'SUCCESS') ? '#28a745' : '#dc3545'
    def subject = "${icon} [${buildStatus}] Jenkins Pipeline: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}"

    def body = """
    <div style="font-family: Arial, sans-serif; border: 1px solid #ddd; padding: 16px; border-radius: 8px;">
        <h2 style="color: ${color}; margin-top: 0;">${icon} Build ${buildStatus}</h2>
        <p><strong>Project:</strong> ${env.JOB_NAME}</p>
        <p><strong>Build Number:</strong> #${env.BUILD_NUMBER}</p>
        <p><strong>SonarQube Dashboard:</strong> <a href="${env.SONAR_HOST_URL}/dashboard?id=python-calculator-cicd">View Code Quality Report</a></p>
        <p><strong>Jenkins Console Output:</strong> <a href="${env.BUILD_URL}console">View Build Logs</a></p>
    </div>
    """

    echo "Preparing Email Notification to ${recipientEmail}..."
    // Uses Jenkins Email Extension Plugin (emailext)
    emailext(
        to: recipientEmail,
        subject: subject,
        body: body,
        mimeType: 'text/html'
    )
}
