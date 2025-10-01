def call(String credId, Closure body) {
    withCredentials([sshUserPrivateKey(credentialsId: credId, keyFileVariable: 'SSH_KEY')]) {
        body()
    }
}
