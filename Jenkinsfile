pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
	   stage('SCM Checkout'){
          git 'https://github.com/awstechguide/devops-demo'
        }

        stage('Build') { 
            steps {
                sh 'mvn clean install' 
            }
        }        
		
		stage('Deploy to AWS'){
      
		  sshagent(['ssh-aws']) {
		  sh 'scp -o StrictHostKeyChecking=no target/*.jar ec2-user@ec2-3-84-250-120.compute-1.amazonaws.com'
		  }

   }
    }
}
