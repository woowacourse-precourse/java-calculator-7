package calculator.domain;

import static calculator.error.ErrorType.EMPTY_CUSTOM_SEPARATOR_ERROR;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private List<String> separators;

    public Separator(List<String> defaultSeparator) {
        this.separators = new ArrayList<>(defaultSeparator);
    }

    public String addCustomSeparator(String input, String customRegex) {
        final Matcher matcher = Pattern.compile(customRegex).matcher(input);
        if (matcher.find()) {
            if(matcher.group(1).isEmpty()) {
                throw new IllegalArgumentException(EMPTY_CUSTOM_SEPARATOR_ERROR.getMessage());
            }
            separators.add(Pattern.quote(matcher.group(1)));
            input = input.substring(matcher.end());
        }
        return input;
    }

    public String[] separateString(final String input) {
        String regex = String.join("|", separators);
        return input.trim().split(regex);
    }
}
