pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio de GitHub
                git 'https://github.com/EdgarTrz/Selenium-Java-TestNG.git'
            }
        }
        stage('Build') {
            steps {
                // Definir la ruta del JDK si no está en el PATH
                // tool 'jdk'

                // Ejecutar la construcción con Maven
                bat 'mvn clean test'
            }
        }
    }
}
