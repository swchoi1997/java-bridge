package global.config;

import bridge.BridgeFactory;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
//import bridge.model.Counter;
//import bridge.model.CounterImpl;

public class AppConfig {

    public BridgeFactory bridgeFactory (){
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

//    public Counter counter() {
//        return new CounterImpl();
//    }
}
