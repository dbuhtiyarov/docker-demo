node {
        checkout scm

        imageName = "dmitrybuhtiyarov/docker-demo:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"
        DockerfilePath = "java/DemoSpringBootApp/"

        stage('Build')
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_id') {
        def customImage = docker.build("$imageName", "$DockerfilePath")
        customImage.push()
        customImage.push('latest')    
    }
        stage('Deploy') {
        sh "docker rm -f demo"
        sh "docker pull $imageName"
        sh "docker run --name demo -p 8080:8080 -d $imageName"
        sh "docker ps -a --filter 'name=demo'"
    }
}
