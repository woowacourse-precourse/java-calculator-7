package calculator;

public class CalculatorFunctions {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String str , String delimiter) {

        // 만약 delimiter의 입력값이 없으면 DEFAULT_DELIMITER 사용
        String useDelimiter = delimiter.isEmpty() ? DEFAULT_DELIMITER : delimiter;

        String[] token = str.split(useDelimiter);
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

    public static int useCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");

        String customDelimiter = input.substring(2, delimiterIndex);
        String str = input.substring(delimiterIndex + 2);
        return splitAndSum(str, customDelimiter);
    }
}
