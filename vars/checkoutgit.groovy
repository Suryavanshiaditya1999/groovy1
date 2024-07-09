import org.Opstree.jenkins.stages.BuildStage

def call() {
    new CheckoutStage().call()
}
