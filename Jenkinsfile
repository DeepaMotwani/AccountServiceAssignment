node {
  git credentialsId: '74971268-164f-4780-9506-26a782949e58', url: 'https://github.com/DeepaMotwani/AccountServiceAssignment.git'
   sh 'gradle clean build'
      //  buuild your REST_API application and copy your war file to your tomcat webapps folder
   dir('build/libs'){
   sh 'cp AccountService-v1.war ../../tomcat/webapps/'
   }
   //build UI project and copy its build folder into tomcat webapps directory
   dir('src/UI/account-service'){
   sh 'npm run build'
   sh 'cp dist/AccountServiceApp ../../tomcat/webapps/AccountServiceApp'
   }
   //go to bin folder of tomcat to start the tomcat
   dir('tomcat/bin'){
       sh 'startup.sh'
   }
   
}