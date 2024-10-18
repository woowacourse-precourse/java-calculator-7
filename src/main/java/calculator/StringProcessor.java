package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static String[] splitWithDelimiter(String expression) {
        return expression.split(",|:");
    }

    public static String[] splitWithCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression.replace("\\n", "\n"));
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        return splitWithDelimiter(expression);
    }

    public static int calculate(String[] expression) {
        int sum = 0;
        for (String s : expression) {
            int operand = Integer.parseInt(s);
            if (operand < 0) {
                throw new IllegalArgumentException("음수는 덧셈 대상이 아님");
            }
            sum += operand;
        }
        return sum;
    }
}
