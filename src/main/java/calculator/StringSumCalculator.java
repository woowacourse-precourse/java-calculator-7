package calculator;

import java.util.List;

public class StringSumCalculator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StringSumCalculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void sum() {
        String input = inputHandler.input();
        if (input.startsWith("//") && input.contains("\\n")) {
            Delimiter customDelimiter = Delimiter.createCustomDelimiter(input);
            String numbersWithDelimiter = input.substring(input.indexOf("\\n") + 2);
            splitAndSum(numbersWithDelimiter, customDelimiter);
        } else {
            Delimiter customDelimiter = Delimiter.createDefaultDelimiter();
            splitAndSum(input, customDelimiter);
        }
    }

    private void splitAndSum(String numbersWithDelimiter, Delimiter delimiter) {
        String[] splitedNumbers = DelimiterSeparator.split(numbersWithDelimiter, delimiter);
        List<PositiveNumber> numbers = NumberListConverter.toNumbers(splitedNumbers);
        PositiveNumber sum = Calculator.sum(numbers);
        outputHandler.printResult(sum);
    }
}
