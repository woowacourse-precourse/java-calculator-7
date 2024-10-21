package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        InputValidator.validate(input);
        if (input.startsWith("//")) {
            return customDelimiter(input);
        }
        return sum(parseNumbers(input, ",|;"));
    }

    private static int customDelimiter(String input) {
        String[] parts = DelimiterParser.customDelimiterParse(input);
        String customDelimiter = parts[0];
        String numbers = parts[1];
        return sum(parseNumbers(numbers, customDelimiter));
    }

    private static int[] parseNumbers(String input, String delimiter) {
        String[] tokens = input.split(DelimiterParser.delimiterPattern(delimiter));
        int[] numbers = new int[tokens.length];
        StringBuilder negatives = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = parseAndValidate(tokens[i], negatives);
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.: " + negatives);
        }
        return numbers;
    }

    private static int parseAndValidate(String token, StringBuilder negatives) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                if (!negatives.isEmpty()) {
                    negatives.append(", ");
                }
                negatives.append(number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력했습니다: " + token);
        }
    }

    private static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}