package calculator.domain;

import java.util.List;

public class CalculatorNumbers {
    private final List<CalculatorNumber> value;

    private CalculatorNumbers(List<CalculatorNumber> calculatorNumbers) {
        this.value = calculatorNumbers;
    }

    public static CalculatorNumbers from(List<CalculatorNumber> calculatorNumbers) {
        List<CalculatorNumber> immutableList = List.copyOf(calculatorNumbers);
        return new CalculatorNumbers(immutableList);
    }
}
