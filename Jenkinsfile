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

        stage('Debug Target') {
            steps {
                sh 'ls -l target'
            }
        }

        stage('Find JAR') {
            steps {
                script {
                    def jarFile = sh(
                        script: "find target -maxdepth 1 -name '*.jar' | grep -v sources | grep -v original | head -n 1",
                        returnStdout: true
                    ).trim()

                    if (!jarFile) {
                        error "No runnable JAR found in target/"
                    }

                    env.JAR_PATH = jarFile
                    echo "Using JAR: ${env.JAR_PATH}"
                }
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
