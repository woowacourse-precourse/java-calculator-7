package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int ZERO = 0;
    private static final String DOUBLE_SLASH = "//";
    private static final String ESCAPE = "\\n";
    private static final String BASIC_DELIMITER = ",|:";
    private static final String REGEX = "\\//(.)\\\\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }
        if (isContainsCustomDelimiter(input)) {
            return calculateSumByMatcher(input);
        }
        return calculateSum(splitInput(input));
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isContainsCustomDelimiter(String input) {
        return input.contains(DOUBLE_SLASH) && input.contains(ESCAPE);
    }

    private static int calculateSumByMatcher(String input) {
        Matcher matcher = getMatcher(input);
        if (canFindRegex(matcher)) {
            return calculateSum(splitInputByCustomDelimiter(matcher));
        }
        // TODO : 예외처리
        return ZERO;
    }

    private static Matcher getMatcher(String input) {
        return PATTERN.matcher(input);
    }

    private static boolean canFindRegex(Matcher matcher) {
        return matcher.find();
    }

    private static String[] splitInput(String input) {
        if (!input.contains(",") && !input.contains(":")) {
            throw new IllegalArgumentException("잘못된 구분자입니다");
        }
        return input.split(BASIC_DELIMITER);
    }

    private static String[] splitInputByCustomDelimiter(Matcher matcher) {
        String delimiter = findDelimiterGroup(matcher);
        String string = findStringGroup(matcher, delimiter);
        return string.split(delimiter);
    }

    private static String findStringGroup(Matcher matcher, String delimiter) {
        String string = matcher.group(SECOND);
        // TODO : 커스텀 구분자를 정의한 상태에서, 문자열에 커스텀 구분자가 아닌 다른 구분자가 들어가있다면 어떻게 해야 할까?
        return string;
    }

    private static String findDelimiterGroup(Matcher matcher) {
        return matcher.group(FIRST);
    }

    private static int calculateSum(String[] strArr) {
        int sum = 0;
        for (String str : strArr) {
            int number = stringToInteger(str);
            checkNegative(number);
            sum += number;
        }
        return sum;
    }

    private static int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("문자열에 음수가 포함되어있습니다");
        }
    }
}
