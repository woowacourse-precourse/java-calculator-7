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
        Delimiters delimiters = null;
        String cutInput = null;
        if (customDelimiterParser.hasCustomDelimiter(input)) {
            String customDelimiter = customDelimiterParser.parse(input).get();
            delimiters = Delimiters.createWithCustomDelimiter(customDelimiter);
            cutInput = customDelimiterParser.excludeFromPrefixToSuffixBy(input);
        } else {
            delimiters = Delimiters.create();
            cutInput = input;
        }
        List<String> allDelimiters = delimiters.getAllDelimiters();
        InputParser inputParser = InputParser.getInstance();
        String[] values = inputParser.parseByDelimiter(cutInput, allDelimiters);
        return values;
    }

    private void validatePositiveNumber(String[] values) {
        NumberValidator numberValidator = NumberValidator.getInstance();
        numberValidator.validatePositiveNumbers(values);
    }

    private int[] convertToInt(String[] values) {
        int[] numbers = PositiveNumberConverter.convertToInt(values);
        return numbers;
    }

    private int getSum(int[] numbers) {
        Calculator calculator = Calculator.getInstance();
        int sum = calculator.add(numbers);
        return sum;
    }

}
