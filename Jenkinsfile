@Library('jenkins-library') import com.varun.jenkins.Utils
def utils = new Utils(this)

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    utils.withMaven do: "package", withArgFile: ".jenkins/stage.build.env.json"
                }
                bat("E:/Varun/apps/apache-maven/apache-maven-3.6.3/bin/mvn -s E:/Varun/apps/apache-maven/apache-maven-3.6.3/conf/settings.xml test")
            }
            post {
                always {
                    junit 'target/surefire-reports/TEST*.xml'
                }
            }
        }
        // stage('Build Docker') {
        //     steps {
        //         script {
        //             utils.withDocker do: "build", withArgFile: ".jenkins/stage.build.docker.env.json"
        //         }
        //     }
        // }
        // stage('Deploy To ECS') {
        //     steps {
        //         script {
        //             utils.withTerraform do: "fargateDeploy", withArgFile: ".jenkins/stage.terraform.fargate_deploy_vars.json"
        //         }
        //     }
        // }
    }
}