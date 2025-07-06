pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'anjali8329/insurance-me-app:latest'
        DOCKER_CREDENTIALS = 'dockerhub-credentials'
    }

    stages {
        stage('Checkout') {
            steps {
                 git 'https://github.com/anjali-shette01/Insurance-me.git' // Replace with your repo URL
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvnw.cmd clean test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build(DOCKER_IMAGE)
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Clean up') {
            steps {
                bat "docker rmi ${DOCKER_IMAGE}"
            }
        }
    }
}
