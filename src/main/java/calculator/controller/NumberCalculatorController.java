package calculator.controller;

import calculator.common.di.NumberCalculatorDependencyRegistry;
import calculator.model.number.service.NumberService;

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

        List<? extends Number> numbers = convertToNumbers(input);

        Number sum = numberService.sum(numbers, numberClass);

        outputView.printSumResult(sum);
    }

    private List<? extends Number> convertToNumbers(String input) {
        return numberService.convertFrom(splitInputByDelimiters(input), numberClass);
    }

    private List<String> splitInputByDelimiters(String input) {
        return delimiterService.splitByDelimiters(input);
    }
}
