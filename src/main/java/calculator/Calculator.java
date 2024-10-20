package calculator;

import java.util.Scanner;

public class Calculator {
    void start() {
        final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(START_MESSAGE);
        work();
    }

    private void work() {
        String input = inputString();
        int result = calculateSum(input);
        printResult(result);
    }

    private String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]"; // 기본 구분자 설정

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 2);
            }
        }

        // 문자열 유효성 검사
        validateInput(input, delimiter);

        return sumTokens(input, delimiter);
    }

    private int sumTokens(String input, String delimiter) {
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("허용되지 않는 문자가 포함되어 있습니다: " + token);
                }
            }
        }
        return sum;
    }

    private void validateInput(String input, String delimiter) {
        String allowedPattern = "[0-9" + delimiter + "//" + "\\n]*";
        if (!input.matches(allowedPattern)) {
            throw new IllegalArgumentException("허용되지 않는 문자가 포함되어 있습니다.");
        }
    }
}