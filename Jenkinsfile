@Library("Shared") _

pipeline{
  agent any
  
  
  parameters{
      choice(name:'ACTION', choices:['Pre-Check','Install','Uninstall'], description: 'Select action to perform')
      text(name: 'SERVER_LIST', defaultValue: '13.234.202.169,13.127.111.45', description: 'Comma-separated list of target servers')
  }
  
  stages {

        stage('Print Inputs') {
            steps {
                script {
                    echo "Selected Action: ${params.ACTION}"
                    echo "Target Servers: ${params.SERVER_LIST}"
                }
            }
        }

        stage('Setup Credentials') {
            steps {
                script {
                    credentials("ansible-ssh-key") {
                        echo "SSH credentials loaded and key available at \$SSH_KEY"
                    }
                }
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                script {
                    credentials("ansible-ssh-key") {
                        ansible("install_ansible.yml", params.SERVER_LIST, params.ACTION)
                    }
                }
            }
        }

        stage('Post Actions') {
            steps {
                script {
                    echo "Pipeline finished successfully for servers: ${params.SERVER_LIST} with action ${params.ACTION}"
                }
            }
        }
    }
}
