package bridge;

public class AppConfig {

    public BridgeFactory bridgeFactory (){
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
