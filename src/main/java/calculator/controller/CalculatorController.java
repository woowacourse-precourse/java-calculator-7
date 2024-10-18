package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomDelimiterParser;
import calculator.model.Delimiters;
import calculator.model.InputParser;
import calculator.model.NumberValidator;
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
        String[] values = parseByDelimiter(input);
        validatePositiveNumber(values);
        int[] numbers = convertToInt(values);
        int sum = getSum(numbers);
        outputView.print(sum);
    }

    private String readLine() {
        return inputView.read();
    }

    private String[] parseByDelimiter(String input) {
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        Optional<String> customDelimiter = customDelimiterParser.parse(input);
        Delimiters delimiters = customDelimiter
                .map(Delimiters::createWithCustomDelimiter)
                .orElse(Delimiters.create());
        String cutInput = customDelimiter
                .map(delimiter -> customDelimiterParser.excludeFromPrefixToSuffixBy(input))
                .orElse(input);
        List<String> allDelimiters = delimiters.getAllDelimiters();
        InputParser inputParser = InputParser.getInstance();
        return inputParser.parseByDelimiter(cutInput, allDelimiters);
    }

    private void validatePositiveNumber(String[] values) {
        NumberValidator numberValidator = NumberValidator.getInstance();
        numberValidator.validatePositiveNumbers(values);
    }

    private int[] convertToInt(String[] values) {
        return PositiveNumberConverter.convertToInt(values);
    }

    private int getSum(int[] numbers) {
        Calculator calculator = Calculator.getInstance();
        int sum = calculator.add(numbers);
        return sum;
    }

}
