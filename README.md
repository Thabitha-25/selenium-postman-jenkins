# Selenium & Jenkins Continuous Integration Project

## Project Description

This project demonstrates Continuous Integration (CI) using Jenkins to automatically build and execute Selenium WebDriver automation tests whenever code is pushed to a GitHub repository.

The framework is designed using:
- Java
- Selenium WebDriver
- TestNG
- Maven
- Jenkins (Pipeline job)

Configuration and test data are externalized using properties files and CSV files, making the framework scalable and maintainable.

---

## Tools & Technologies Used

- Jenkins - CI/CD automation
- Java (JDK 17) - Programming language
- Selenium WebDriver - UI automation
- TestNG - Test execution & reporting
- Maven - Build & dependency management
- Git & GitHub - Version control
- Firefox Browser - Test execution

---

## Application Under Test

Login Page: https://the-internet.herokuapp.com/login

---

## Project Structure

```
selenium-postman-jenkins/
│
├── src/main/java/
│   └── com/login/base/
│       ├── BaseTest.java
│       └── ConfigReader.java
│
├── src/main/resources/
│   └── config.properties
│
├── src/test/java/
│   └── com/login/tests/
│       └── LoginTest.java
│
├── src/test/resources/
│   └── testdata/
│       └── loginData.csv
│
├── pom.xml
├── Jenkinsfile
└── README.md
```

---

## Configuration Details

### config.properties

Located at: src/main/resources/config.properties

```properties
url=https://the-internet.herokuapp.com/login
browser=firefox
```

- URL and browser are configurable
- Browser execution is currently set to Firefox

---

## Test Data Management

Test data is stored in CSV format:

**Location:** src/test/resources/testdata/loginData.csv

- Used for login test scenarios
- Helps achieve data-driven testing

---

## Test Cases Implemented

### Selenium Login Test Scenarios

**1. Valid Login Test**
- Login using valid credentials
- Verify successful login message

**2. Invalid Login Test**
- Login using invalid credentials
- Verify error message is displayed

**3. Data-Driven Login Test**
- Reads credentials from CSV file
- Executes multiple login combinations

---

## Running Tests Locally

### Prerequisites

- Java JDK 17
- Maven
- Firefox Browser
- GeckoDriver configured in system path
- Git

### Steps

1. Clone the repository:

```bash
git clone <your-github-repository-url>
```

2. Navigate to the project folder:

```bash
cd selenium-postman-jenkins
```

3. Run tests:

```bash
mvn clean test
```

---

## Jenkins Setup

### Jenkins Job Type

Pipeline Job

### Jenkins Configuration

- Jenkins installed locally
- GitHub repository connected
- Required plugins installed:
  - Git Plugin
  - Maven Plugin
  - TestNG Plugin

### Jenkins Pipeline Flow

1. Checkout code from GitHub
2. Build project using Maven
3. Execute Selenium TestNG tests
4. Publish test results

---

## Jenkinsfile Overview

The Jenkinsfile is present in the root directory and defines:
- Source code checkout
- Maven build execution
- Automated Selenium test execution
- Test report generation

---

## Test Reports

- TestNG reports are generated after execution
- Jenkins displays:
  - Total test count
  - Passed / Failed tests
  - Build status (SUCCESS / FAILURE)

---

## CI/CD Concepts Implemented

- Continuous Integration (CI)
- Automated test execution on every Git commit
- Externalized configuration management
- Data-driven testing
- Pipeline as Code (Jenkinsfile)

---

## Notes

- API testing using Postman is not implemented in this project
- Focus is on Selenium UI automation integrated with Jenkins
- Browser execution can be changed via config.properties

---

## Sample Jenkinsfile

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven'
        jdk 'JDK17'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo/selenium-postman-jenkins.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
```

---
---

## Author

Automation Tester
