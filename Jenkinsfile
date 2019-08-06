node {
    stage('Clone sources') {
        checkout scm;
    }

    env.BRANCH_NAME = env.BRANCH_NAME ? env.BRANCH_NAME : 'master';
    def imageName = "dmitrybuhtiyarov/docker-demo:${env.BRANCH_NAME}.${env.BUILD_NUMBER}";
    def registryUrl = "https://registry.hub.docker.com";
    def registryCredentialsId = "dockerhub_id";

    docker.withRegistry(registryUrl, registryCredentialsId) {
        def customImage;
        stage('Build') {
            customImage = docker.build("$imageName", "java/DemoSpringBootApp/");
        }
        stage('Push') {
            customImage.push();
            if (env.BRANCH_NAME == 'master') {
                ansiColor('xterm') {
                    echo("\033[0;32mJob started from master branch, pushing \'latest\' tag\033[0m");
                }
                customImage.push('latest');
            }
        }
    }

    stage('Deploy') {
        sh("""
            docker rm -f demo || true && docker pull $imageName
            docker run --name demo -p 8080:8080 -d $imageName
            docker ps -a --filter 'name=demo'
        """);
    }
}
