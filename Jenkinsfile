pipeline {
    agent any
    envioroment { 
       PATH = "C:\maven\apache-maven-3.9.4\bin:$PATH"
    }

    stages {
        stage('git') {
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
