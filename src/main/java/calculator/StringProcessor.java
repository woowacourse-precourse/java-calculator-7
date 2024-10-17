package calculator;

public class StringProcessor {
    public static String[] splitWithDelimiter(String expression) {
        return expression.split(",|;");
    }

    public static int calculate(String[] expression) {
        int sum = 0;
        for (String s : expression) {
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
}
