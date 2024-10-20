package calculator;

public class Calculator {
    private final InputReader inputReader;
    private final Parser parser;
    private final DelimiterManager delimiterManager;

    public Calculator() {
        this.inputReader = new InputReader();
        this.parser = new Parser();
        this.delimiterManager = new DelimiterManager();
    }

    public int calculate() {
        String input = inputReader.readInput();
        ParsedInput parsedInput = parser.parse(input);

        if (parsedInput.expression().isEmpty()) {
            return 0; // 빈 입력일 경우 0 반환
        }

        String delimiter = delimiterManager.extractDelimiter(parsedInput.command());
        String[] numbers = parsedInput.expression().split(delimiter);

        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number.trim());
        }
        return sum;
    }

    private int parseNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + num);
        }
    }
}
