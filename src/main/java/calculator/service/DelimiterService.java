package calculator.service;

import calculator.exception.ErrorMessage;

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
            return matcher.group(2).substring(2).split(matcher.group(1));
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_FOUND_DELIMITER.getMessage());
    }

    private String[] splitByDefaultDelimiters(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

}