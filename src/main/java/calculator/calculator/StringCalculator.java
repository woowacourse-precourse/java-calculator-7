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
                    if (number < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += number;
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
            }
        }

        return sum;
    }
}
