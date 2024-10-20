package calculator;

public class CustomDelimiterCalculator extends Calculator {
    public CustomDelimiterCalculator(String input) {
        super(input);
    }

    @Override
    public int calculate() {
        int endDelimiter = input.indexOf("\\n");
        String delimiter = String.valueOf(input.charAt(2));
        input = input.substring(endDelimiter + 2);

        String[] parts = input.split(delimiter);
        return sumPositiveNumbers(parts);
    }
}