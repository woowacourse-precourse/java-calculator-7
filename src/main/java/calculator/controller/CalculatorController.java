package calculator.controller;

import calculator.model.CustomDelimiter;
import calculator.model.Delimiters;
import calculator.model.InputParser;
import calculator.model.InputValidator;
import calculator.model.NumberValidator;
import calculator.model.PositiveNumbers;
import calculator.util.PositiveNumberConverter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;
import java.util.Optional;

public class CalculatorController {
    private final InputView inputView = InputView.INSTANCE;
    private final OutputView outputView = OutputView.INSTANCE;

    public void run() {
        String input = readLine();
        validateInput(input);
        String[] values = parseByDelimiter(input);
        validateNumber(values);
        int[] numbers = convertToInt(values);
        int sum = getSum(numbers);
        outputView.print(sum);
    }

    private String readLine() {
        return inputView.read();
    }

    private void validateInput(String input) {
        InputValidator inputValidator = InputValidator.getInstance();
        inputValidator.validate(input);
    }

    private String[] parseByDelimiter(String input) {
        CustomDelimiter customDelimiter = CustomDelimiter.getInstance();
        Optional<String> customDelimiterOrEmpty = customDelimiter.parse(input);
        Delimiters delimiters = customDelimiterOrEmpty
                .map(Delimiters::createWithCustomDelimiter)
                .orElse(Delimiters.create());
        String cutInput = customDelimiterOrEmpty
                .map(delimiter -> customDelimiter.excludeFromPrefixToSuffixBy(input))
                .orElse(input);
        List<String> allDelimiters = delimiters.getAllDelimiters();
        InputParser inputParser = InputParser.getInstance();
        return inputParser.parseByDelimiter(cutInput, allDelimiters);
    }

    private void validateNumber(String[] values) {
        NumberValidator numberValidator = NumberValidator.getInstance();
        numberValidator.validateNumbers(values);
    }

    private int[] convertToInt(String[] values) {
        return PositiveNumberConverter.convertToInt(values);
    }

    private int getSum(int[] numbers) {
        PositiveNumbers positiveNumbers = PositiveNumbers.getInstance(numbers);
        int sum = positiveNumbers.sum();
        return sum;
    }

}
