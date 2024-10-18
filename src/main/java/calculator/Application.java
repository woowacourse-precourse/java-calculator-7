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

        if (usesCustomDelimiter(text)) {
            String[] textAndDelimiters = extractCustomDelimiter(text, delimiters);
            text = textAndDelimiters[0];
            delimiters = textAndDelimiters[1];
        }


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
