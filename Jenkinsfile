pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean install -DskipTests'
            }
        }

        stage('Unit Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('SonarQube') {
            steps {
                sh '''
            ./mvnw sonar:sonar \
            -Dsonar.projectKey=telecom-workforce-platform \
            -Dsonar.host.url=http://host.docker.internal:9000 \
            -Dsonar.login=sqa_e92aa93db4c1ca712261a2626ad596271a6767d1
            '''
            }
        }
    }
}