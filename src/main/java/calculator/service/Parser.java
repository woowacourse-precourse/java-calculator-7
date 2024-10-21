package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final char COMMA = ',';
    private static final char SEMICOLON = ':';
    private static final String BASIC_DELIMITER = "[" + COMMA + SEMICOLON + "]";
    private static final String CUSTOM_DELIMITER = "^//(.*?)\\\\n(.*)";

    public static void parse(String line) {
        if (isCustomDelimiter(line)) {
            parseCustomDelimiter(line);
        } else {
            parseBasicDelimiter(line);
        }
    }

    private static void parseBasicDelimiter(String line) {
        String[] numbers = line.split(BASIC_DELIMITER);
    }

    private static void parseCustomDelimiter(String line) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbersPart = matcher.group(2);

            String[] numbers = numbersPart.split(customDelimiter);
        } else {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private static boolean isCustomDelimiter(String line) {
        return line.matches(CUSTOM_DELIMITER);
    }

}
