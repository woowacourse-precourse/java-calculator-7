package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterService {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITERS = "//(.)\n(.*)";

    public String[] splitNumbers(String input) {
        if (isCustomDelimiter(input)) {
            return splitByCustomDelimiters(input);
        }

        return splitByDefaultDelimiters(input);
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && !input.substring(2, input.indexOf("\n"))
                .isEmpty();
    }

    private String[] splitByCustomDelimiters(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITERS).matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("매칭되는 구분자가 없습니다.");
        }

        return matcher.group(2).split(matcher.group(1));
    }

    private String[] splitByDefaultDelimiters(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

}