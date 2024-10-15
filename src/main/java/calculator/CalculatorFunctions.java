package calculator;

public class CalculatorFunctions {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum (String str) {

        String[] token = str.split(DEFAULT_DELIMITER);
        return addToken(token);
    }

    public static int addToken(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            if(token.isEmpty()) continue;

            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
