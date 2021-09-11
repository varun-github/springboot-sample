@Library('jenkins-library') import com.varun.jenkins.Utils
def utils = new Utils(this)

pipeline {
    agent any
    environment{
        JIRA_EPIC_KEY = "CATE-1"
    }
    stages {
        stage('Build') {
            environment{
                JIRA_STORY_KEY = "CATE-12"
            }
            steps {
                script {
                    utils.withMaven do: "package", withArgFile: ".jenkins/stage.build.env.json"
                }
            }
            post {
                always {
                    echo("ALWAYS ECHO SOMETHING STUPID")
                }
            }
        }
        stage('Build Docker') {
            environment{
                JIRA_STORY_KEY = "CATE-13"
            }
            steps {
                script {
                    utils.withDocker do: "build", withArgFile: ".jenkins/stage.build.docker.env.json"
                }
            }
        }
        stage('Deploy To ECS') {
            environment{
                JIRA_STORY_KEY = "CATE-14"
            }
            steps {
                script {
                    utils.withTerraform do: "fargateDeploy", withArgFile: ".jenkins/stage.terraform.fargate_deploy_vars.json"
                }
            }
        }
    }
}