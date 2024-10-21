package calculator;

public class StringAddCalculator {
    private StringAddCalculator() {
        // 인스턴스 생성 방지
    }

    public static double calculate(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        NumberTokens tokens = InputProcessor.process(input);
        return tokens.sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
