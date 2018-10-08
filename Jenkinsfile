node {
        stage('Clone sources') {
        git url: 'https://github.com/dbuhtiyarov/docker-demo.git'
    }
        stage('Build')
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_id') {
        def customImage = docker.build("dmitrybuhtiyarov/docker-demo:2.${env.BUILD_NUMBER}", "java/DemoSpringBootApp/")
        customImage.push()
        customImage.push('latest')    
    }
        stage('Deploy') {
        sh "docker rm -f demo"
        sh "docker pull dmitrybuhtiyarov/docker-demo:2.${env.BUILD_NUMBER}"
        sh "docker run --name demo -p 8080:8080 -d dmitrybuhtiyarov/docker-demo:2.${env.BUILD_NUMBER}"
        sh "docker ps -a --filter 'name=demo'"
    }
}
