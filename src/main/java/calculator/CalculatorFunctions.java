package calculator;

public class CalculatorFunctions {

    private static String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String str) {

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

    public static String customDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, delimiterIndex);
        String str = input.substring(delimiterIndex + 2);
        addNewDelimiter(customDelimiter);

        return str;
    }

    public static void addNewDelimiter(String customDelimiter) {
         DEFAULT_DELIMITER = DEFAULT_DELIMITER + "|" + customDelimiter;
    }
}
