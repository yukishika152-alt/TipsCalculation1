pipeline {
    agent any

    tools {
        maven 'Maven-3.9.9'
        jdk 'JDK-21'
    }

    environment {
        PROJECT_NAME = 'tips-calculation'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Building ${PROJECT_NAME}"
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Unit Tests & Coverage') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit testResults: 'target/surefire-reports/*.xml',
                         skipMarkingBuildUnstable: false
                }
            }
        }
    }

    post {
        always {
            jacoco execPattern: '**/target/jacoco.exec',
                    classPattern: '**/target/classes',
                    sourcePattern: '**/src/main/java',
                    exclusionPattern: '**/*Test*',
                    minimumLineCoverage: '60.0',
                    minimumBranchCoverage: '70.0',
                    changeBuildStatus: true,
                    buildOverBuild: true

            archiveArtifacts artifacts: 'target/*.jar',
                         fingerprint: true,
                         allowEmptyArchive: true
        }

        failure {
            echo "Build failed! Check the logs above."
        }

        success {
            echo "Build successful! Coverage report published."
        }
    }
}
