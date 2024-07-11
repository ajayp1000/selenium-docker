pipeline{

    agent any

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
    }


}