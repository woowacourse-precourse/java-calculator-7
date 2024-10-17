package calculator;

public class CalculatorFactory {
    public static Calculator getCalculator(String str) {
        return new DefaultCalculator(str);
    }
}
