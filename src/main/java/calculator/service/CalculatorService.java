package calculator.service;

import calculator.domain.Calculator;

import java.util.List;

public class CalculatorService {

    Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public void getInputValues(String input) {
        calculator.setRawValue(input);
    }

    public void validateInput() {
    }

    public List<Integer> extractNumbersToList() {
        return List.of();
    }

    public int sumOfList() {
        return 0;
    }

    public String printResult() {
        return null;
    }
}

