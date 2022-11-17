package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.AppConfig;
import bridge.BridgeFactory;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private BridgeFactory bridgeFactory;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        bridgeFactory = appConfig.bridgeFactory();
    }

    @Test
    void createBridge(){
        assertThat(new Bridge(List.of("U", "D,", "D"))).isEqualTo(new Bridge(List.of("U", "D,", "D")));
    }



}