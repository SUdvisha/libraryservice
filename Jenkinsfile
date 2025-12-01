pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "library-service-image"
    }

    // Various stages in the Pipeline Process:
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/SUdvisha/libraryservice.git'
            }
        }

        stage('Build') {
            steps {
                // Build docker image using Dockerfile
                bat "docker build -t ${DOCKER_IMAGE} -f Dockerfile ."
            }
        }

        stage('K8s Deployment') {
            steps {
                script {
                    withEnv(["KUBECONFIG=C:/Users/udvis/.kube/config"]) {

                        bat "kubectl apply -f k8s/namespace.yaml --validate=false"
                        bat "kubectl apply -f k8s/deployment.yaml --validate=false"
                        bat "kubectl apply -f k8s/service.yaml --validate=false"

                    }
                }
            }
        }
    }

    post {
        success {
            echo "✅ Checkout, Build, Dockerize & Deploy completed successfully!"
        }
        failure {
            echo "❌ Build failed!"
        }
    }
}