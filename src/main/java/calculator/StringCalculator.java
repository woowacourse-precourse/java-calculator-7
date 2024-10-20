package calculator;

public class StringCalculator {
    public static int add(String input) {
        // 빈 문자열 또는 null일 경우 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            return CustomDelimiterCalculator.calculateSum(input);
        }

        return StandardDelimiterCalculator.calculateSum(input);
    }
}
