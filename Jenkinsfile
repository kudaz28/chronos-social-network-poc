pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/willkzhou/Chronos.git', branch: 'master', poll: true)
      }
    }
  }
  environment {
    dev = 'development'
  }
}