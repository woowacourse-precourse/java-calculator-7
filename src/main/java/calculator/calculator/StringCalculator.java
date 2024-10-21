package calculator.calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] tokens = InputParser.parse(input);
        int sum = 0;

        for (String token : tokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + token);
                }
            }
        }

        return sum;
    }
}
