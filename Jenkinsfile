pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio de GitHub utilizando credenciales almacenadas
                git credentialsId: 'Jenkins-credential', url: 'https://github.com/EdgarTrz/Selenium-Java-TestNG.git'
            }
        }
        stage('Build') {
            steps {
                // Ejecutar la construcción con Maven
                bat 'mvn clean test'
            }
        }
    }
}
