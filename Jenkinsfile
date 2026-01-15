pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Build Project') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build and tests successful'
        }

        failure {
            echo 'Build or tests failed'
        }
    }
}
