package calculator;

public class StringAddCalculator {

    private final InputValidator validator = new InputValidator();
    private static final String SEPARATOR = ",|:";

    public int add(String input) {

        if(validator.isNull(input)) {
            return 0;
        }

        if (validator.isInvalidFormat(input)) {
            throw new IllegalArgumentException();
        }

        if (validator.isCustomDelimExists(input)) {
            String customDelimiter = String.valueOf(input.charAt(2));
            String numbers = input.substring(5);
            return calculate(numbers, customDelimiter);
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

    private int calculate(String input) {
        String[] split = input.split(SEPARATOR);
        int sum = 0;

        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
