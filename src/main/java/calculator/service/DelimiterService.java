package calculator.service;

import calculator.exception.ErrorMessage;
import calculator.util.IntegerUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterService {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITERS = "//(.)(.*)";

    public String[] splitNumbers(String input) {
        if (isDefaultDelimiters(input)) {
            return splitByDefaultDelimiters(input);
        }
        if (isCustomDelimiter(input)) {
            return splitByCustomDelimiters(input);
        }
        return new String[]{input};
    }

    private boolean isDefaultDelimiters(String input) {
        return input.contains(",") || input.contains(":");
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && input.startsWith("\\n", 3);
    }

    private String[] splitByCustomDelimiters(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITERS).matcher(input);

        if (matcher.find()) {
            validateMatcherGroup(matcher);
            return matcher.group(2).substring(2).split(Pattern.quote(matcher.group(1)));
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_FOUND_DELIMITER.getMessage());
    }

    private String[] splitByDefaultDelimiters(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

    private void validateMatcherGroup(Matcher matcher) {
        if (IntegerUtils.isNumeric(matcher.group(1))) {
            throw new IllegalArgumentException("커스텀 문자에 숫자를 입력할 수 없습니다.");
        }
    }

}