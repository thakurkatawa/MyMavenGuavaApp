pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/thakurkatawa/MyMavenGuavaApp.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Find JAR') {
            steps {
                script {
                    def jarFile = sh(
                        script: "ls target/*.jar | head -n 1",
                        returnStdout: true
                    ).trim()

                    env.JAR_PATH = jarFile
                    echo "Found JAR: ${env.JAR_PATH}"
                }
            }
        }

        stage('Verify JAR') {
            steps {
                sh 'ls -l target'
            }
        }

        stage('Run Application') {
            steps {
                sh "java -jar ${env.JAR_PATH}"
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
