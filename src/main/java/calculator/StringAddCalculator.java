package calculator;

public class StringAddCalculator {

    private final InputValidator validator = new InputValidator();
    private static final String SEPARATOR = ",|:";

    public double add(String input) {

        if(validator.isNull(input)) {
            return 0;
        }

        if (validator.isCustomDelimiter(input)) {
            String customDelimiter = String.valueOf(input.charAt(2));
            String numbers = input.substring(5);

            if (validator.isInvalidFormat(numbers.replace(customDelimiter, ","))) {
                throw new IllegalArgumentException();
            }

            return calculate(numbers, customDelimiter);
        }

        if (validator.isInvalidFormat(input)) {
            throw new IllegalArgumentException();
        }

        return calculate(input);
    }

    private int calculate(String numbers, String delimiter) {
        String[] split = numbers.split(delimiter);
        int sum = 0;

        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    private double calculate(String input) {
        String[] split = input.split(SEPARATOR);
        double sum = 0;

        for (String s : split) {
            sum += Double.parseDouble(s);
        }

        return sum;
    }

}
