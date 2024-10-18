package calculator.controller;

import calculator.common.config.NumberCalculatorDependencyRegistry;
import calculator.util.number.NumberUtils;

import java.util.List;

public class NumberCalculatorController extends CalculatorController {

    private final Class<? extends Number> numberClass;

    public NumberCalculatorController(NumberCalculatorDependencyRegistry dependencyRegistry) {
        super(dependencyRegistry);
        this.numberClass = dependencyRegistry.getNumberClass();
    }

    @Override
    public void run() {
        String input = inputView.readUserInput();
        List<String> numberStrings = splitInputByDelimiters(input);
        List<? extends Number> numbers = parseNumberStrings(numberStrings);
        Number sum = calculateSum(numbers);
        outputView.printSumResult(sum);
    }

    private List<String> splitInputByDelimiters(String input) {
        return delimiterService.splitByDelimiters(input);
    }

    private List<? extends Number> parseNumberStrings(List<String> numberStrings) {
        return NumberUtils.parseNumbers(numberStrings, numberClass);
    }

    private Number calculateSum(List<? extends Number> numbers) {
        return NumberUtils.sum(numbers, numberClass);
    }
}
