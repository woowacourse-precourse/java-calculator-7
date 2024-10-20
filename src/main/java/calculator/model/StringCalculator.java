package calculator.model;

public class StringCalculator {
    private final InputParser inputParser;

    public StringCalculator() {
        this.inputParser = new InputParser();
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = inputParser.parse(input);
    }
}
