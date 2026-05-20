pipeline {

    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://gitlab.com/telecom/project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t telecom-app .'
            }
        }

    }
}