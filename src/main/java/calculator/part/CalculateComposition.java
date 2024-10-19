package calculator.part;

public class CalculateComposition {

    private final CalculatorAdder calculatorAdder;

    public CalculateComposition(CalculatorAdder calculatorAdder) {
        this.calculatorAdder = calculatorAdder;
    }

    public int makeSum(int [] numberArr){
        return calculatorAdder.calculateAdd(numberArr);
    }
}
