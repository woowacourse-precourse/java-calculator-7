package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final char COMMA = ',';
    private static final char SEMICOLON = ':';
    private static final String BASIC_DELIMITER = "[" + COMMA + SEMICOLON + "]";
    private static final String CUSTOM_DELIMITER = "^//(.*?)\\\\n(.*)";

    public static int parse(String line) {
        if (isCustomDelimiter(line)) {
            return parseCustomDelimiter(line);
        } else {
            return parseBasicDelimiter(line);
        }
    }

    private static int parseBasicDelimiter(String line) {
        String[] numbers = line.split(BASIC_DELIMITER);
        return sumNumbers(numbers);
    }

    private static int parseCustomDelimiter(String line) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbersPart = matcher.group(2);

            String[] numbers = numbersPart.split(customDelimiter);
            return sumNumbers(numbers);
        } else {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private static boolean isCustomDelimiter(String line) {
        return line.matches(CUSTOM_DELIMITER);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());

            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }

        return sum;
    }

}
