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
        int result;

        if (usesCustomDelimiter(text)) {
            String[] textAndDelimiters = extractCustomDelimiter(text, delimiters);
            text = textAndDelimiters[0];
            delimiters = textAndDelimiters[1];
        }

        result = calculateSum(text, delimiters);
        output(result);

    }

    public static int calculateSum(String text, String delimiters) {
        String[] textSplitArr = text.split(delimiters);

        int sum = 0;
        for (String s : textSplitArr) {
            int num = Integer.parseInt(s);
            sum += num;
        }

        return sum;
    }

    public static void output(int result) {
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

        delimiters = delimiters + "|" + "\\Q" + customDelimiter + "\\E";

        return new String[]{text, delimiters};
    }
}
