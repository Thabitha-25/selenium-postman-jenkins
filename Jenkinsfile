pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/Thabitha-25/selenium-postman-jenkins.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Run Postman API Tests') {
            steps {
                bat 'newman run postman/login_api_collection.json'
            }
        }
    }

    post {
        always {
            publishTestNGResults testResultsPattern: '**/testng-results.xml'
        }
        success {
            echo 'Build and tests executed successfully'
        }
        failure {
            echo 'Build or tests failed'
        }
    }
}
