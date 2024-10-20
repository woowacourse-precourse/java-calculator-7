package calculator.controller;

import calculator.common.Delimiters;
import calculator.domain.AdditionCalculator;
import calculator.domain.Calculator;
import calculator.util.CustomDelimiterExtractor;
import calculator.util.CustomDelimiterRemover;
import calculator.util.NumberExtractor;
import calculator.validator.CalculableValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;
import java.util.Set;

public class CalculatorController {

    private final Calculator calculator;

    public CalculatorController() {
        this.calculator = new AdditionCalculator();
    }

    public void startCalculate() {
        String calculationInput = getCalculationInput();
        Delimiters delimiters = initializeDelimiters(calculationInput);
        List<Long> numbers = extractNumbers(calculationInput, delimiters);
        long result = calculate(numbers);
        printResult(result);
    }

    private String getCalculationInput() {
        OutputView.printCalculationInputMessage();
        return InputView.inputCalculationString();
    }

    private Delimiters initializeDelimiters(String input) {
        Set<String> customDelimiters = CustomDelimiterExtractor.parse(input);
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(customDelimiters);
        return delimiters;
    }

    private List<Long> extractNumbers(String input, Delimiters delimiters) {
        String cleanedInput = CustomDelimiterRemover.removeCustomDelimiters(input);
        CalculableValidator.validate(cleanedInput, delimiters);
        return NumberExtractor.parseNumbers(cleanedInput, delimiters);
    }

    private long calculate(List<Long> numbers) {
        return calculator.sum(numbers);
    }

    private void printResult(long result) {
        OutputView.printExecutionResultMessage(result);
    }
}