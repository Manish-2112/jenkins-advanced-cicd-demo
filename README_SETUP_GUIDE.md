# Jenkins Advanced CI/CD Demo (Shared Libraries, Unit Tests, SonarQube & Email)

This bundle contains two clean project folders designed to be pushed to GitHub so you can test an end-to-end Jenkins Pipeline on your AWS EC2 instance.

## Folder Structure
1. **`1-python-app-repo/`**: Your main application repository containing:
   - `app/calculator.py`: A Python order & discount calculator with a deliberate SonarQube code smell (`unused_debug_flag`) so you can see SonarQube detect real issues.
   - `tests/test_calculator.py`: 6 unit tests using `pytest` that generate both `test-results.xml` (for Jenkins UI) and `coverage.xml` (for SonarQube coverage tracking).
   - `sonar-project.properties`: Configuration file telling SonarQube where your source code, tests, and coverage reports live.
   - `Jenkinsfile`: The declarative pipeline orchestrating Docker agents, Shared Library calls, JUnit reporting, SonarQube scanning, and Email alerts.

2. **`2-jenkins-shared-library-repo/`**: Your reusable Jenkins Shared Library repository containing:
   - `vars/logStageBanner.groovy`: Prints formatted stage headers in the console log.
   - `vars/runPythonUnitTests.groovy`: Encapsulates virtual environment creation, pip install, and `pytest` execution.
   - `vars/sendBuildEmail.groovy`: Sends an HTML-formatted build summary email using `emailext`.
