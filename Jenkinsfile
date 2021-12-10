node {
 withEnv(['AZURE_SUBSCRIPTION_ID=0b7486c2-0ba3-4a81-b89d-255d03f24d86',
        'AZURE_TENANT_ID=91206dcf-2888-4e27-8f76-242ef4f9ea10']) {
    stage('init') {
      checkout scm
    }
  
    stage('build') {
      sh 'mvn clean package'
    }
  
    stage('deploy') {
      def webAppResourceGroup = 'Jenkins-VM_group'
      def webAppName = 'FlemensScoreApp'
      def acrName = 'FlemensScoresACR'
      def imageName = 'flemens-scores'
      def imageWithTag = "miwi94/$imageName:latest"
      
     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKERHUB_PW', usernameVariable: 'DOCKERHUB_ID')]) {
      // login docker
        // docker.withRegistry only supports credential ID, so use native docker command to login
        // you can also use docker.withRegistry if you add a credential
        sh "docker login -u $DOCKERHUB_ID -p $DOCKERHUB_PW"
        // build image
        def image = docker.build imageWithTag
        // push image
        image.push()
      }
      withCredentials([usernamePassword(credentialsId: 'AzureServicePrincipal', passwordVariable: 'AZURE_CLIENT_SECRET', usernameVariable: 'AZURE_CLIENT_ID')]) {
        
        sh '''
          az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET -t $AZURE_TENANT_ID
          az account set -s $AZURE_SUBSCRIPTION_ID
        '''
        // update web app docker settings
        sh "az webapp config container set -g $webAppResourceGroup -n $webAppName -c $imageName -r $imageWithTag -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET"
        // log out
        sh 'az logout'
        sh "docker logout $loginServer"
      }
    }
  }
}
