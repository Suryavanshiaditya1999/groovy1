def call() {
    def unitTesting = new org.jenkinsci.pipeline.UnitTesting(this)
    unitTesting.setup()
}
