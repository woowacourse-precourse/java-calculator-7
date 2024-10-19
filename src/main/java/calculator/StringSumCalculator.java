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
        if (Delimiter.isCustomDelimiter(input)) {
            Delimiter customDelimiter = Delimiter.createCustomDelimiter(input);
            String numbersWithDelimiter = input.substring(input.indexOf(Delimiter.CUSTOM_DELIMITER_SUFFIX) + 2);
            splitAndSum(numbersWithDelimiter, customDelimiter);
        } else {
            Delimiter defaultDelimiter = Delimiter.createDefaultDelimiter();
            splitAndSum(input, defaultDelimiter);
        }
    }

    private void splitAndSum(String numbersWithDelimiter, Delimiter delimiter) {
        String[] splitedNumbers = DelimiterSeparator.split(numbersWithDelimiter, delimiter);
        List<PositiveNumber> numbers = NumberListConverter.toNumbers(splitedNumbers);
        PositiveNumber sum = PositiveNumber.sum(numbers);
        outputHandler.printResult(sum);
    }
}
