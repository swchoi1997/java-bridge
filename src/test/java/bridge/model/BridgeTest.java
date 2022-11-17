package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.AppConfig;
import bridge.BridgeFactory;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("가야하는 순서와, 유저 선택이 주어졌을 때 갈수있는 곳이 일치하면 true를 반환한다.")
    @ParameterizedTest(name = "bridge [U | D | D]  step : {0}, pick : {1}")
    @CsvSource({"0, U", "1, D", "2, D"})
    void canGo(Integer step, String userPick) {
        assertTrue(new Bridge(List.of("U", "D", "D")).canGoOrNot(step, userPick));
    }

    @DisplayName("가야하는 순서와, 유저 선택이 주어졌을 때 갈수있는 곳이 일치하지 않으면 false를 반환한다.")
    @ParameterizedTest(name = "bridge [U | D | D]  step : {0}, pick : {1}")
    @CsvSource({"0, D", "1, U", "2, U"})
    void canNotGo(Integer step, String userPick) {
        assertFalse(new Bridge(List.of("U", "D", "D")).canGoOrNot(step, userPick));
    }


}