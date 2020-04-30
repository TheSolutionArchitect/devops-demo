node{
   stage('SCM Checkout'){
     git 'https://github.com/awstechguide/devops-demo'
   }
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'maven-3', type: 'maven'   
      sh "${mvnHome}/bin/mvn install"
   }
   stage('Deploy to AWS'){
      
      sshagent(['ssh-aws']) {
      sh 'scp -o StrictHostKeyChecking=no target/*.jar ec2-user@ec2-3-84-250-120.compute-1.amazonaws.com'
      }

   }
}
