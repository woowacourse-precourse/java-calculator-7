package calculator;

public class DefaultCalculator extends Calculator {
    public DefaultCalculator(String input) {
        super(input);
    }
    @Override
    public int calculate() {
        String delimiter = "[,:]";
        String[] parts = input.split(delimiter);
        return sumPositiveNumbers(parts);
    }
}
