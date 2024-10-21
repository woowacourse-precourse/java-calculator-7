package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final char COMMA = ',';
    private static final char SEMICOLON = ':';
    private static final String BASIC_DELIMITER = "[" + COMMA + SEMICOLON + "]";
    private static final String CUSTOM_DELIMITER = "^//(.*?)\\\\n(.*)";

    public static String parse(String input) {
        if (isCustomDelimiter(input)) {
            return parseCustomDelimiter(input);
        } else {
            return parseBasicDelimiter(input);
        }
    }

    private static String parseBasicDelimiter(String input) {
        String[] numbers = input.split(BASIC_DELIMITER);
        return sumNumbers(numbers);
    }

    private static String parseCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbersPart = matcher.group(2);

            String[] numbers = numbersPart.split(customDelimiter);
            return sumNumbers(numbers);
        } else {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private static boolean isCustomDelimiter(String input) {
        return input.matches(CUSTOM_DELIMITER);
    }

    private static String sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number.trim());

                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
            }
        }


        return Integer.toString(sum);
    }

}
