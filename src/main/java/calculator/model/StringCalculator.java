package calculator.model;

public class StringCalculator {
    private final InputParser inputParser;
    private final SumCalculator sumCalculator;

    public StringCalculator() {
        this.inputParser = new InputParser();
        this.sumCalculator = new SumCalculator();
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = inputParser.parse(input);
        return sumCalculator.calculateSum(numbers);
    }
}
