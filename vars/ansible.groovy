def call(String playbook, String servers, String action, String towerIp) {
    sh """
        ansible-playbook -i ${servers.replaceAll(",", " ")} ${playbook} \
        --extra-vars "action=${action} tower_ip=${towerIp}"
    """
}
