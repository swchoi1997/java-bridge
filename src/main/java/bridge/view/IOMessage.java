package bridge.view;

import bridge.dto.StepResponseDto;
import java.util.List;

public enum IOMessage {

    START_LINE("["),
    END_LINE("]"),
    SUCCESS(" O "),
    FAIL(" X "),
    EMPTY("   "),
    SPLIT("|");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public static void getStepMessage(StepResponseDto stepResponseDto) {
        if (stepResponseDto.isSuccess()) {
            successMessage(stepResponseDto.getStep());
            return;
        }
        failMessage(stepResponseDto.getStep());
    }

    private static void failMessage(List<String> step) {
        String upperBridge = "";
        String underBridge = "";
        for (int i = 0; i < step.size(); i++) {
            if (i == step.size() - 1) {
                if (step.get(i).equals("U")) {
                    upperBridge += FAIL.message;
                    underBridge += EMPTY.message;
                } else{
                    upperBridge += EMPTY.message;
                    underBridge += FAIL.message;
                }
                continue;
            }
            if (step.get(i).equals("U")) {
                upperBridge += SUCCESS.message + SPLIT.message;
                underBridge += EMPTY.message + SPLIT.message;
            } else{
                upperBridge += EMPTY.message + SPLIT.message;
                underBridge += SUCCESS.message + SPLIT.message;
            }
        }
        System.out.println(START_LINE.message + upperBridge + END_LINE.message +
                "\n" + START_LINE.message + underBridge + END_LINE.message);
        System.out.println();
    }

    private static void successMessage(List<String> step) {
        String upperBridge = "";
        String underBridge = "";
        for (int i = 0; i < step.size(); i++) {
            if (i == step.size() - 1) {
                if (step.get(i).equals("U")) {
                    upperBridge += SUCCESS.message;
                    underBridge += EMPTY.message;
                } else{
                    upperBridge += EMPTY.message;
                    underBridge += SUCCESS.message;
                }
                continue;
            }
            if (step.get(i).equals("U")) {
                upperBridge += SUCCESS.message + SPLIT.message;
                underBridge += EMPTY.message + SPLIT.message;
            } else{
                upperBridge += EMPTY.message + SPLIT.message;
                underBridge += SUCCESS.message + SPLIT.message;
            }
        }
        System.out.println(START_LINE.message + upperBridge + END_LINE.message +
                "\n" + START_LINE.message + underBridge + END_LINE.message);
        System.out.println();
    }

    public static void finalStepMessage(StepResponseDto stepResponseDto) {
        System.out.println("최종 게임 결과");
        if (stepResponseDto.isSuccess()) {
            successMessage(stepResponseDto.getStep());
            summaryMessage(stepResponseDto.getRetryCount(), stepResponseDto.isFinal());
            return;
        }
        failMessage(stepResponseDto.getStep());
        summaryMessage(stepResponseDto.getRetryCount(), stepResponseDto.isFinal());
    }
    private static void summaryMessage(int retryCount, boolean isFinal) {
        if (isFinal) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + retryCount);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + retryCount);

    }
}


