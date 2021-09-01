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
                echo "set"
                script{
                    git_repo = env.GIT_URL.replaceFirst(/.*\/([\w-]+).*/, '$1')
                    print('$WORKSPACE $git_repo')
                    print("$env.WORKSPACE ${git_repo}")
                    // docker.build("${env.}:${env.BUILD_ID}")
                }

            }
        }
    }
}