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
        JAVA_HOME = '/opt/apps/jdk/11/11.2.1'
      }
      steps {
        script {
          utils.withMaven do: "package", withArgFile: ".jenkins/stage.build.env.json"
        }
      }
      post {
        always {
          echo 'callback'
        }
        failure {
          echo 'failure'
        }
        success {
        }
      }
    }
    stage('Create Docker Image') {
      environment {
      }
      steps {
        script {
          utils.withDocker do: "build", withArgFile: ".jenkins/stage.build.docker.env.json"
        }
      }
    }
    stage('Deploy to AWS Fargate') {
      environment {
      }
      steps {
        script {
          utils.withTerraform do: "fargateDeploy", withArgFile: ".jenkins/stage.terraform.fargate_deploy_vars.json"
        }
      }
    }
  }
}
