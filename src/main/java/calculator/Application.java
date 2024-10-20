package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String customDelimiterPattern = getCustomDelimiter(input);
        String delimiterPattern;

        if (customDelimiterPattern == null) {
            delimiterPattern = buildDelimiterPattern(COMMA_DELIMITER, COLON_DELIMITER);
        } else {
            delimiterPattern = buildDelimiterPattern(COMMA_DELIMITER, COLON_DELIMITER, customDelimiterPattern);
            input = stripCustomDelimiter(input);
        }

        int totalSum = sumFromNumbers(input, delimiterPattern);
        System.out.println("결과 : " + totalSum);
    }

    private static int sumFromNumbers(String numbers, String delimiterPattern) {
        if (numbers.isEmpty()) return 0;

        String[] numberList = numbers.split(delimiterPattern);
        int sum = 0;
        for (String number : numberList) {
            sum += convertToInt(number);
        }
        return sum;
    }

    private static int convertToInt(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }

    private static String getCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static String stripCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return input;
    }

    private static String buildDelimiterPattern(String... delimiters) {
        StringBuilder delimiterBuilder = new StringBuilder();
        for (String delimiter : delimiters) {
            delimiterBuilder.append(Pattern.quote(delimiter)).append("|");
        }
        delimiterBuilder.setLength(delimiterBuilder.length() - 1);
        return delimiterBuilder.toString();
    }
}
