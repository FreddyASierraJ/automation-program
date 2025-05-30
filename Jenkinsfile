pipeline {
agent any
tools {
maven 'maven-3.9.9' // Usa el nombre que configuraste en Jenkins
jdk 'jdk-17' // Nombre del JDK configurado
}
stages {
stage('Checkout') {
steps {
checkout scm
}
}
stage('Build & Test') {
steps {
bat 'mvn clean test -Dgroups="Action_Regression,CreditCards_Regression,ProductDetail_Regression"'
}
}
}
post {
always {
junit 'target/surefire-reports/*.xml'
archiveArtifacts artifacts: 'reports/**.html', fingerprint: true
publishHTML([
reportDir: 'reports',
reportFiles: '*.html',
reportName: 'Extent Report',
keepAll: true,
alwaysLinkToLastBuild: true,
allowMissing: false
])
}
}
}