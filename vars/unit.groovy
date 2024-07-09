def call() {
    def utils = new org.jenkinsci.pipeline.Utils(this)
    utils.setUpVirtualEnv()
}
