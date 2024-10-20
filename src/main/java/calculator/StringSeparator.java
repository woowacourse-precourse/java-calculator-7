package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private final ValidChecker validChecker = new ValidChecker();

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");      // 정규 표현식을 통해 커스텀 구분자의 길이가 1을 넘을 수 없음

    public String[] parseNumbers(String input) {
        validChecker.emptyStringCheck(input);

        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input);
        }

        String[] splitStrings = input.split(DEFAULT_DELIMITER);
        standardValidations(input, splitStrings, DEFAULT_DELIMITER);

        return Arrays.stream(splitStrings)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private String[] parseWithCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        validChecker.customDelimiterCheck(matcher);

        String delimiter = matcher.group(1);
        String numbers = matcher.group(2);
        validChecker.customDelimiterNumCheck(delimiter);

        String allDelimiter = String.format("(%s|%s)", DEFAULT_DELIMITER, Pattern.quote(delimiter));
        String[] splitStrings = numbers.split(allDelimiter);
        standardValidations(input, splitStrings, allDelimiter);
        return splitStrings;
    }

    private void standardValidations(String input, String[] splitStrings, String delimiter) {
        validChecker.numberCheck(splitStrings);
        validChecker.delimiterCheck(splitStrings);
        validChecker.lastCharCheck(input, delimiter);
    }
}
