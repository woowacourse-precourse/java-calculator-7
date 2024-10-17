package calculator;

public class Calculation {
    private String str;
    private Calculator strategy;

    public Calculation(String str) {
        this.str = str;
        this.strategy = CalculatorFactory.getCalculator(str);
    }

    public int calculate() {
        return strategy.calculate();
    }
}
