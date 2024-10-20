package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static String customDelimiterPattern = "\\/\\/(.*)\\\\n(.*)";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String text = Console.readLine();
        String delimiters = "\\,|\\:";
        long result;

        if (usesCustomDelimiter(text)) {
            String[] textAndDelimiters = extractCustomDelimiter(text, delimiters);
            text = textAndDelimiters[0];
            delimiters = textAndDelimiters[1];
        }

        if (text.isEmpty()) {
            result = 0;
        } else {
            result = calculateSum(text, delimiters);
        }

        output(result);
    }

    public static void output(long result) {
        System.out.println("결과 : " + result);
    }

    public static boolean usesCustomDelimiter(String text) {
        return text.matches(customDelimiterPattern);
    }

    public static String[] extractCustomDelimiter(String text, String delimiters) {
        Matcher customDelimiterMatcher = Pattern.compile(customDelimiterPattern).matcher(text);

        customDelimiterMatcher.find();
        String customDelimiter = customDelimiterMatcher.group(1);
        text = customDelimiterMatcher.group(2);

        delimiters = "\\Q" + customDelimiter + "\\E" + "|" + delimiters;

        return new String[]{text, delimiters};
    }

    public static long calculateSum(String text, String delimiters) {
        String[] textSplitArr = text.split(delimiters, -1);

        long sum = 0;
        for (String s : textSplitArr) {
            validateArrElement(s);
            long num = Long.parseLong(s);
            sum += num;
        }

        return sum;
    }

    public static void validateArrElement(String s) {
        if (s.isBlank() || !Pattern.matches("^[0-9]*$", s)) {
            throw new IllegalArgumentException();
        }
    }
}