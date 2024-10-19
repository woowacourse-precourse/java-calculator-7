package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        ParsedInput parsedInput = InputParser.parse(input);
        return parsedInput.numbers().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}