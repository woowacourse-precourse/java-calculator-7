package calculator.part;

import java.math.BigInteger;

public class CalculateComposition {

    private final CalculatorAdder calculatorAdder;

    public CalculateComposition(CalculatorAdder calculatorAdder) {
        this.calculatorAdder = calculatorAdder;
    }

    public BigInteger makeSum(BigInteger[] numberArr){
        return calculatorAdder.calculateAdd(numberArr);
    }
}
