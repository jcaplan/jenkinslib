def setupEnv(Map depends) {
    def depend_string = ''
    for (dep in depends.keySet()){
        checkout([
            $class: 'GitSCM',
            branches: [[name: '*/master']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [],
            submoduleCfg: [],
            userRemoteConfigs: [[url: 'https://github.com/pytest-dev/pytest.git']]
        ])
        depend_string += ' $dep'
    }
    sh '''
    virtualenv env -p python3
    . ./env/bin/activate
    pip install $depend_string
    '''
}

def setupPytest() {
    setupEnv(
        "pytest": "https://github.com/pytest-dev/pytest.git"
    )
}