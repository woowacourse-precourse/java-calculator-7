package calculator;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return calculateSum(input, DEFAULT_DELIMITERS);
    }

    private static int calculateSum(String input, String delimiter) {
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
        }
}