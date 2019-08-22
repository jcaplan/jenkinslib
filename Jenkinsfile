@Library('library') _

def jobs = [:]
for (c in (1..30).toList()) {
    def name = c.toString()
    jobs[name] = {
        node {
            stage(name) {
                echo name
            }
        }
    }
}


node {
    stage('clone') {
        git 'https://github.com/jcaplan/jenkinslib.git'
    }
}

parallel jobs