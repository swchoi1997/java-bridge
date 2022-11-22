package bridge;


import bridge.controller.BridgeGame;
import bridge.dto.StepResponseDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeProgram {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();


    private BridgeProgram(){
    }

    private static class BridgeHolder{
        private static final BridgeProgram INSTANCE = new BridgeProgram();
    }

    public static BridgeProgram getInstance() {
        return BridgeHolder.INSTANCE;
    }

    public void start(){
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        StepResponseDto stepResponse = null;
        String quitPoint = "";
        while (!quitPoint.equals("Q")) {
            stepResponse = bridgeGame.move(inputView.readMoving());
            outputView.printMap(stepResponse);
            quitPoint = checkProgress(bridgeGame, stepResponse);
        }
        outputView.printResult(stepResponse);
    }

    private String checkProgress(BridgeGame bridgeGame, StepResponseDto stepResponse) {
        if (!stepResponse.isSuccess()) {
            return bridgeGame.retry(inputView.readGameCommand());
        }
        if (stepResponse.isFinal()){
            return  "Q";
        }
        return "";
    }
}
