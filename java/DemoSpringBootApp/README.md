# Repo contains java code for Springboot and Dockerfile  

## Workflow
## Docker build
`docker build --pull=true --force-rm -t ${REGISTY}/${REPO}:${VERSION} .`
<br/>`Example:` docker build --pull=true --force-rm -t dmitrybuhtiyarov/docker-demo:1.0 .

## Docker run
`docker run --name demo -p ${HOST_PORT}:${CONTAINER_PORT} -d ${IMAGE_NAME}:${VERSION}`
<br/>`Example:` docker run --name demo -p 80:8080 -d dmitrybuhtiyarov/docker-demo:1.0

## Docker push (upload to registry)
`docker push ${IMAGE_NAME}:${VERSION}`
<br/>`Example:` docker push dmitrybuhtiyarov/docker-demo:1.0
<br/>`DockerHub:` https://hub.docker.com/r/dmitrybuhtiyarov/docker-demo/ 
