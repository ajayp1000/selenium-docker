pipeline{

    agent any

    tools {
      maven 'MAVEN_HOME'
    }

    stages{

        stage('Build Jar'){
            steps{
                sh "mvn clean package -DskipTests"
            }
        }

        stage('Build Image'){
            steps{
                sh "docker build -t=ajayp100/selenium ."
            }
        }

        stage('Image Push'){
            environment{
            DOCKER_HUB = credentials('docker-creds')
            }
            steps{
                sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                sh "docker push ajayp100/selenium"
            }
        }

        stage('Copying the Jar to Lib folder'){
                    steps{
                        sh "cp target/docker-resources/selenium-docker.jar target/docker-resources/libs/"
                        sh "cp target/docker-resources/selenium-docker-tests.jar target/docker-resources/libs/"
            }
        }
    }

    post{
        always{
        sh "docker system prune -f"
        sh "docker logout"
        }
    }


}