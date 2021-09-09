@Library('jenkins-library') import com.varun.jenkins.Utils
def utils = new Utils(this)
pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr:'10'))
    timeout(time: 1, unit: 'HOURS')
  }
  stages {
    stage('Build Java Springboot App') {
      environment {
        BUILD_ENV = 'DEVELOPMENT'
      }
      steps {
        script {
          utils.withMaven do: "package", withArgFile: ".jenkins/stage.build.env.json"
        }
      }
      post {
        always {
          echo 'mandatory'
        }
        failure {
          echo 'failure'
        }
        success {
          echo 'success'
        }
      }
    }
    stage('Create Docker Image') {
      steps {
        script {
          utils.withDocker do: "build", withArgFile: ".jenkins/stage.build.docker.env.json"
        }
      }
    }
    stage('Deploy to AWS Fargate') {
      steps {
        script {
          utils.withTerraform do: "fargateDeploy", withArgFile: ".jenkins/stage.terraform.fargate_deploy_vars.json"
        }
      }
    }
  }
}
