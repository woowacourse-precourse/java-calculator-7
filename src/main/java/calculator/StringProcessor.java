package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static String[] splitWithDelimiter(String expression) {
        return expression.split(",|:");
    }

    public static String[] splitWithCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression.replace("\\n","\n"));
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
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
}
