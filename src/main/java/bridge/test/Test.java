package bridge.test;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Test {
    private static final List<String> USER_COMMAND = List.of("U", "D", "Q" ,"R");

    private static String input = null;
    private static String validateInput = null;


    public static void main(String[] args) {
        testInput();
    }

    private static void testInput() {
        while (!"Q".equals(input)) {
            try {
                validateInput = validate(input());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            input = validateInput;
            System.out.println(input);
        }
    }

    private static String input() {
        System.out.println("입력 부탁");
        return Console.readLine();
    }

    private static String validate(String input) {
        if (!USER_COMMAND.contains(input)) {
            validateInput = null;
            throw new IllegalArgumentException("[ERROR] 잘못된 입력했음");
        }
        return input;
    }
    private static void print(String input) {
        System.out.println(input);
    }
}
