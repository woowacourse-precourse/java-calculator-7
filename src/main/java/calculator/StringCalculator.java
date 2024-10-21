package calculator;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = tokenize(input);
        return sumTokens(tokens);
    }

    private static String[] tokenize(String input) {
        return input.split(",|:");
    }
}
