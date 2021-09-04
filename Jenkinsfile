@Library('jenkins-library')
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withMaven do: "package", withArgFile: ".jenkins/stage.build.env.json"
            }
            // environment{
            //     MAVEN_HOME = "E:/Varun/apps/apache-maven/apache-maven-3.6.3"
            //     MAVEN_SETTINGS = "E:/Varun/apps/apache-maven/apache-maven-3.6.3/conf/settings.xml"
            // }
            // steps {
            //     bat '%MAVEN_HOME%/bin/mvn -s %MAVEN_SETTINGS% -DskipTests clean package' 
            // }
        }
        // stage('Build Docker'){
        //     environment{
        //         AWS_PROFILE = "wintel"
        //         AWS_REGION = "us-east-2"
        //         ECR_REGISTRY = "667811466675.dkr.ecr.us-east-2.amazonaws.com"
        //         DOCKER_REPO_PREFIX = "com.wipro.cloudstudio/microservices"
        //     }
        //     steps{
        //         bat 'aws ecr get-login-password  | docker login --username AWS --password-stdin %ECR_REGISTRY%'
        //         script{
        //             git_repo = env.GIT_URL.replaceFirst(/.*\/([\w-]+).*/, '$1')
        //             def img = docker.build("${env.ECR_REGISTRY}/${env.DOCKER_REPO_PREFIX}/${git_repo}:${env.BRANCH_NAME}.${env.BUILD_ID}")
        //             img.push()
        //         }
        //     }
        // }
    }
}