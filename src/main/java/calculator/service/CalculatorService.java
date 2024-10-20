package calculator.service;

import calculator.domain.Calculator;

import java.util.List;

public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculateSum(String inputString) {
        Character customSeparator = calculator.extractCustomSeparator(inputString);
        String removedDeclarePart = calculator.removeDeclarePart(inputString, customSeparator);
        String[] removedSeparatorsArray = calculator.removeSeparators(removedDeclarePart, customSeparator);
        List<Integer> parsedIntegers = calculator.parseStringToInteger(removedSeparatorsArray);
        return calculator.sumInteger(parsedIntegers);
    }
}
