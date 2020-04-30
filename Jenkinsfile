pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
	   stage('SCM Checkout'){
	    steps {
          git 'https://github.com/awstechguide/devops-demo'
		  }
        }

        stage('Build') { 
            steps {
                sh 'mvn install' 
            }
        }        
		
		stage('Deploy to AWS'){
      steps {
		  sshagent(['ssh-aws']) {
		  sh 'scp -o StrictHostKeyChecking=no target/*.jar ec2-user@3.84.250.120:/home/ec2-user'
		  }
		  }

   }
    }
}
