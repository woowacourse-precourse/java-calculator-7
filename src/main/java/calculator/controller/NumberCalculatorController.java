package calculator.controller;

import calculator.common.di.NumberCalculatorDependencyRegistry;
import calculator.service.NumberService;

import java.util.List;

public class NumberCalculatorController extends CalculatorController {

    private final NumberService numberService;
    private final Class<? extends Number> numberClass;

    public NumberCalculatorController(NumberCalculatorDependencyRegistry numberCalculatorDependencyRegistry) {
        super(numberCalculatorDependencyRegistry);
        this.numberService = numberCalculatorDependencyRegistry.getNumberService();
        this.numberClass = numberCalculatorDependencyRegistry.getNumberClass();
    }

    @Override
    public void run() {
        String input = inputView.readUserInput();
        List<String> numberStrings = splitInputByDelimiters(input);

        List<? extends Number> numbers = numberService.convertFrom(numberStrings, numberClass);
        Number sum = numberService.sum(numbers, numberClass);

        outputView.printSumResult(sum);
    }

    private List<String> splitInputByDelimiters(String input) {
        return delimiterService.splitByDelimiters(input);
    }
}
