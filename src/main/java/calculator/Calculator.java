package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public int process() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        if (userInput.trim().isBlank()) {
            return 0;
        }

        if (!userInput.startsWith("//")) {
            String delimiter = ",:";
            String[] split = userInput.split("[" + delimiter + "]");

            validatePositiveNumber(split);

            return sum(split);
        }

        String delimiter = ",:";
        int endIdx = userInput.indexOf("\\n");
        validateWrongCustom(endIdx);
        String custom = userInput.substring(2, endIdx);
        delimiter += custom;
        String[] split = userInput.substring(endIdx + 2).split("[" + delimiter + "]");
        validatePositiveNumber(split);
        return sum(split);
    }

    private static void validateWrongCustom(int endIdx) {
        if (endIdx == -1 || endIdx - 2 > 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositiveNumber(String[] split) {
        for (String s : split) {
            if (Integer.parseInt(s) <= 0) {
                throw new IllegalArgumentException("음수 입력 x");
            }
        }
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String c : split) {
            sum += Integer.parseInt(c);
        }

        return sum;
    }
}
