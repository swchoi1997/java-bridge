package bridge.model;

import static global.advice.SizeValidator.checkIsDigit;
import static global.advice.SizeValidator.checkLength;
import static global.advice.SizeValidator.checkRange;

import bridge.BridgeFactory;
import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public Bridge(BridgeFactory bridgeFactory, String size) {
        validation(size);
        this.bridge = bridgeFactory.makeBridge(Integer.parseInt(size));
    }

    private void validation(String size) {
        checkLength(size);
        checkIsDigit(size);
        checkRange(size);
    }

    public boolean canGoOrNot(int step, String userPick) {
        return bridge.get(step).equals(userPick);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge1 = (Bridge) o;
        return Objects.equals(bridge, bridge1.bridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge);
    }
}
