package calculator.part;

import calculator.NumberWrapper;

public class CalculateComposition {

    private final CalculatorAdder calculatorAdder;

    public CalculateComposition(CalculatorAdder calculatorAdder) {
        this.calculatorAdder = calculatorAdder;
    }

    public NumberWrapper makeSum(NumberWrapper[] numberArr){
        return calculatorAdder.calculateAdd(numberArr);
    }
}
