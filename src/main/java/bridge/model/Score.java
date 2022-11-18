package bridge.model;

import static bridge.model.Judgment.*;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private List<String> step;
    private int retryCount;

    public Score() {
        this.step = new ArrayList<>();
        this.retryCount = 1;
    }

    public List<String> getStep() {
        return step;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public Judgment goOneStep(Bridge bridge, String moving) {
        this.step.add(moving);
        if (bridge.canGoOrNot(this.step, moving)){
            return SUCCESS;
        }
        return FAIL;
    }

    public Judgment isCrossing(Bridge bridge) {
        if (bridge.isCrossing(step.size())) {
            return CROSSING;
        }
        return PROGRESS;
    }

    public String retryGame(String retry) {
        if ("R".equals(retry)) {
            this.step = new ArrayList<>();
            this.retryCount += 1;
        }
        return retry;
    }
}
