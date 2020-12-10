node {
    checkout scm
    stage('Build') {
        sh 'make' 
        archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
    }
    stage('Test') {
        /* `make check` 在测试失败后返回非零的返回码；
        * 使用 `true` 允许流水线继续进行
        */
        sh 'make check || true' 
        junit '**/target/*.xml' 
    }
    /* .. snip .. */
    stage('Deploy') {
        if (currentBuild.result == null || currentBuild.result == 'SUCCESS') { 
            sh 'make publish'
        }
    }
    /* .. snip .. */
}
