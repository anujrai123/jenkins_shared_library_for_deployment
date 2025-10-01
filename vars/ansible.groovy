def call(String playbook, String server, String action, String ansibleServerIp) {
    sh """
        ssh -i $SSH_KEY -o StrictHostKeyChecking=no ubuntu@${ansibleServerIp} \
        "ansible-playbook -i '${server},' /home/ubuntu/Ansible/playbook/${playbook} --extra-vars 'action=${action}'"
    """
}

