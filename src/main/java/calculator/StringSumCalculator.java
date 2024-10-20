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
        Delimiter delimiter = Delimiter.create(input);
        String numbersWithDelimiter = removeDelimiterDefinition(input);
        splitAndSum(numbersWithDelimiter, delimiter);
    }

    private String removeDelimiterDefinition(String input) {
        if (Delimiter.isCustomDelimiter(input)) {
            return input.substring(Delimiter.locateCustomDelimiterSuffix(input) + 2);
        }
        return input;
    }

    private void splitAndSum(String numbersWithDelimiter, Delimiter delimiter) {
        String[] splitedNumbers = DelimiterSeparator.split(numbersWithDelimiter, delimiter);
        List<PositiveNumber> numbers = NumberListConverter.toNumbers(splitedNumbers);
        PositiveNumber sum = PositiveNumber.sum(numbers);
        outputHandler.printResult(sum);
    }
}
