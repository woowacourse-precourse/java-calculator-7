package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PREFIX = "결과 : ";
    private static final int EMPTY_STR_RESULT = 0;

    public static void main(String[] args) {
        String input = getInputOrDefault();

        if (input == null) {
            printResult(EMPTY_STR_RESULT);
            return;
        }

        int result = runCalculator(input);
        printResult(result);
    }

    private static String getInputOrDefault() {
        try {
            return getInput();
        } catch (Exception e) {
            return null;
        }
    }

    private static String getInput() {
        System.out.println(PROMPT_MESSAGE);
        return Console.readLine();
    }

    public static int runCalculator(String input) {
        StringParser parser = new StringParser(input);
        Calculator calculator = new Calculator(parser);
        return calculator.calculateSum();
    }

    private static void printResult(int result) {
        System.out.println(RESULT_PREFIX + result);
    }
}
