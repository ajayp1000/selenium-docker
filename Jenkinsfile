pipeline{

    agent any

    tools { 
      maven 'MAVEN_HOME' 
      jdk 'JAVA_HOME' 
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
