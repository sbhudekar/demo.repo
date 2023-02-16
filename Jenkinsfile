pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'apache-maven-3.6.3'
    }

    stages {
        stage('Checking JAVA, Maven,git') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'mvn --version'
                sh 'java --version'
                sh 'git --version'
                sh 'whoami'
                echo "this pipeline is running via Jenkins User"
            }
        }
        stage('Code Compilation') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'mvn --version'
                sh 'mvn clean compile'
            }
        }

        stage('Code QA Execution') {
            steps {
                echo 'Junit Test case check in Progress!'
                sh 'mvn --version'
                sh 'mvn clean test'
            }
        }
        stage('Code Package') {
            steps {
                echo 'Creating War Artifact'
                sh 'java -version'
                sh 'mvn clean package'
            }
        }
    stage('Building  Docker Image') {
            steps {
                    echo 'Starting Building Docker Image'
                    sh 'docker build -t sbhudekar/demo .'
                    sh 'docker build -t demo-ms .'
                    echo 'Completed  Building Docker Image'
            }
         }

            stage('Tagging Docker Image') {
                steps {
                    echo 'Creating War Artifact'
                    sh 'java -version'
                    sh 'mvn clean package'
            }
         }

            stage('Docker Image Scanning') {
                steps {
                    echo 'Creating War Artifact'
                    sh 'java -version'
                    sh 'mvn clean package'
            }
         }
            stage(' Docker push to Docker Hub') {
               steps {
                  script {
                     withCredentials([string(credentialsId: 'dockerD', variable: 'dockerD')]) {
                     sh 'docker login docker.io -u sbhudekar -p ${dockerD}'
                     echo "Push Docker Image to DockerHub : In Progress"
                     sh 'docker push sbhudekar/demo:latest'
                     echo "Push Docker Image to DockerHub : In Progress"
                     sh 'whoami'
                  }
               }
            }
         }
            stage(' Docker Image Push to Amazon ECR') {
              steps {
                  script {
                    withDockerRegistry(credentialsId: 'ecr:ap-northeast-1:aws-ecr-D', toolName: 'Docker', url: 'https://844317626697.dkr.ecr.ap-northeast-1.amazonaws.com/demo-ecr') {
                      sh """
                      echo "List the docker images present in local"
                      docker images
                      echo "Tagging the Docker Image: In Progress"
                      docker tag demo-ecr:latest 844317626697.dkr.ecr.ap-northeast-1.amazonaws.com/demo-ecr:latest
                      echo "Tagging the Docker Image: Completed"
                      echo "Push Docker Image to ECR : In Progress"
                      docker push 844317626697.dkr.ecr.ap-northeast-1.amazonaws.com/demo-ecr:latest
                      echo "Push Docker Image to ECR : Completed"
                      """
                  }
               }
            }
         }
            stage('Upload the docker Image to Nexus') {
               steps {
                  script {
                     nexusArtifactUploader credentialsId: 'nexus', groupId: 'com.example', nexusUrl: '13.230.146.172:8081/repository/demo/', nexusVersion: 'nexus2', protocol: 'http', repository: 'demo', version: '0.0.1-SNAPSHOT'
                     sh 'docker login docker.io -u sbhudekar -p ${dockerD}'
                     echo "Push Docker Image to Nexus : In Progress"
                     sh 'docker tag demo 35.77.228.52:8081/demo:latest'
                     sh 'docker push 35.77.228.52:8081/demo'
                     echo "Push Docker Image to Nexus : Completed"
                  }
              }
            }
         }
            stage('Deploy App to K8s Cluster') {
                steps {
                    sh 'whoami'
                    sh 'kubectl apply -f kubernetes/yatra-ms-prod'
                }
            }
         }
   }

