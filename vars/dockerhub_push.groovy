def call(String dockerUsername, String image) {
    def tag = env.BUILD_NUMBER
    def imageName = "${dockerUsername}/${image}:${tag}"

    withCredentials([
        usernamePassword(
            credentialsId: 'DockerHubCred',
            usernameVariable: 'DOCKERHUB_USER',
            passwordVariable: 'DOCKERHUB_PASS'
        )
    ]) {
        sh """
            set -e

            echo "\$DOCKERHUB_PASS" | docker login \
                -u "\$DOCKERHUB_USER" --password-stdin

            docker tag notes-app:1.0 ${imageName}
            docker push ${imageName}

            docker logout
        """
    }
}
