import groovy.json.JsonSlurper

def getAcrLoginServer(def acrSettingsJson) {
  def acrSettings = new JsonSlurper().parseText(acrSettingsJson)
  return acrSettings.loginServer
}

node {
 withEnv(['AZURE_SUBSCRIPTION_ID=0b7486c2-0ba3-4a81-b89d-255d03f24d86',
        'AZURE_TENANT_ID=91206dcf-2888-4e27-8f76-242ef4f9ea10']) {
    stage('init') {
      checkout scm
    }
  
    stage('build') {
        def webAppResourceGroup = 'flemens_scores_rg'
      def webAppName = 'flemens-scores-webappv2'
      def acrName = 'FlemensScoresACR'
      def imageName = 'flemens-scores'
      // generate version, it's important to remove the trailing new line in git describe output
      def version = sh script: 'git describe | tr -d "\n"', returnStdout: true
      withCredentials([usernamePassword(credentialsId: 'AzureServicePrincipal', passwordVariable: 'AZURE_CLIENT_SECRET', usernameVariable: 'AZURE_CLIENT_ID')]) {
        // login Azure
        sh '''
          az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET -t $AZURE_TENANT_ID
          az account set -s $AZURE_SUBSCRIPTION_ID
        '''
         // get login server
        def acrSettingsJson = sh script: "az acr show -n $acrName", returnStdout: true
        def loginServer = getAcrLoginServer acrSettingsJson
        // login docker
        // docker.withRegistry only supports credential ID, so use native docker command to login
        // you can also use docker.withRegistry if you add a credential
        sh "docker login -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET $loginServer"
        // build image
        def imageWithTag = "$loginServer/$imageName:ver$BUILD_NUMBER"
        def image = docker.build imageWithTag
    }
  
    stage('deploy') {
        // push image
        image.push()
        // update web app docker settings
        sh "az webapp config container set -g $webAppResourceGroup -n $webAppName -c $imageWithTag -r http://$loginServer -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET"
        // log out
        sh 'az logout'
        sh "docker logout $loginServer"
      }
    }
  }
}
