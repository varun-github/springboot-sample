pipeline {
    agent any
    stages {
        stage('Build') {
            environment{
                MAVEN_HOME = "E:/Varun/apps/apache-maven/apache-maven-3.6.3"
                MAVEN_SETTINGS = "E:/Varun/apps/apache-maven/apache-maven-3.6.3/conf/settings.xml"
            }
            steps {
                bat '%MAVEN_HOME%/bin/mvn -s %MAVEN_SETTINGS% -DskipTests clean package' 
            }
        }
        stage('Build Docker'){
            steps{
                script{
                    git_repo = env.GIT_URL.replaceFirst(/.*\/([\w-]+).*/, '$1')
                    def img = docker.build("${git_repo}:${env.BUILD_ID}")
                    print("img " +img)
                }
            }
            // steps{
            //     bat 'docker images'
            // }
        }
    }
}