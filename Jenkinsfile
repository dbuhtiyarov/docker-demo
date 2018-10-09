node {
        checkout scm

        imageName = "dmitrybuhtiyarov/docker-demo:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"
        DockerfilePath = "java/DemoSpringBootApp/"
        appname = "demo"

        stage('Build/Push') 
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_id') {
        def customImage = docker.build("$imageName", "$DockerfilePath")
        customImage.push()
        customImage.push('latest')
    }
        stage('Deploy') {
        sh "docker rm -f $appname"
        sh "docker pull $imageName"
        sh "docker run --name $appname -p 8080:8080 -d $imageName"
        sh "docker ps -a --filter 'name=$appname'"
    }
}
