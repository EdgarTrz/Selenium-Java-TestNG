pipeline {
    agent any

    stages {
        stage('Cloning') {
            steps {
                // Clonar el repositorio de GitHub
                git credentialsId: 'Jenkins-credential', url: 'https://github.com/EdgarTrz/Selenium-Java-TestNG.git'
            }
        }
        stage('Build') {
            steps {
                // Ejecutar la construcción con Maven
                bat 'mvn compile'
            }
            stage('run'){
                bat script: 'mvn test -Dbrowser=localchrome'
            }
            stage('Publish Report')
            echo 'Hello Word;
        }
    }
}
