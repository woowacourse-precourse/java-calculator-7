package calculator;

public class CalculatorFactory {
    public static Calculator getCalculator(String str) {
        if (CustomChecker.check(str)) {
            return new CustomCalculator(str);
        }
        return new DefaultCalculator(str);
    }
}
