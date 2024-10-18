package calculator.controller;

import calculator.common.config.NumberCalculatorDependencyRegistry;
import calculator.model.delimiter.service.DelimiterService;
import calculator.util.integer.IntegerUtils;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final DelimiterService delimiterService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(NumberCalculatorDependencyRegistry dependencyRegistry) {
        this.delimiterService = dependencyRegistry.getDelimiterService();
        this.inputView = dependencyRegistry.getInputView();
        this.outputView = dependencyRegistry.getOutputView();
    }

    public void run() {
        String input = inputView.readUserInput();
        List<String> numberStrings = splitInputByDelimiters(input);
        List<Integer> numbers = parseNumberStringsToIntegers(numberStrings);
        int sum = calculateSum(numbers);
        outputView.printSumResult(sum);
    }

    private List<String> splitInputByDelimiters(String input) {
        return delimiterService.splitByDelimiters(input);
    }

    private List<Integer> parseNumberStringsToIntegers(List<String> numberStrings) {
        return IntegerUtils.parseIntegers(numberStrings);
    }

    private int calculateSum(List<Integer> numbers) {
        return IntegerUtils.sum(numbers);
    }
}
