pipeline{

    agent any

    stages{

         stage('Build Maven PATH'){
                    steps{
                        sh "export MAVEN_HOME=/home/ec2-user/apache-maven-3.9.8"
                        sh "export PATH=$PATH:$MAVEN_HOME/bin"
                        sh "mvn --version"
            }
         }

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
            steps{
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


}