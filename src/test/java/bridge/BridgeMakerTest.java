package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import config.AppConfig;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private final List<String> STANDARD_BRIDGE = List.of("U", "D");

    private BridgeFactory bridgeFactory;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        bridgeFactory = appConfig.bridgeFactory();
    }

    @DisplayName("입력한 숫자만큼 다리길이가 생성된다")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10", "11"})
    void makeBridge(String input) {
        List<String> bridge = bridgeFactory.makeBridge(input);
        assertThat(bridge.size()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("다리는 U/D 문자로 이루어져있다.")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10", "11"})
    void checkBridgeConsistOfUOrD(String input) {
        for (String bridgeShape : bridgeFactory.makeBridge(input)) {
            assertTrue(STANDARD_BRIDGE.contains(bridgeShape));
        }
    }
}