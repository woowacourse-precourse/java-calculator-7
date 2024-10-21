package calculator.domain;

import static calculator.error.ErrorType.EMPTY_CUSTOM_SEPARATOR_ERROR;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private final Set<String> separators;

    public Separator(Set<String> defaultSeparator) {
        this.separators = new HashSet<>(defaultSeparator);
    }

    public String addCustomSeparator(String input, final String customRegex) {
        final Matcher matcher = Pattern.compile(customRegex).matcher(input);
        if (matcher.find()) {
            if(matcher.group(1).isEmpty()) {
                throw new IllegalArgumentException(EMPTY_CUSTOM_SEPARATOR_ERROR.getMessage());
            }
            separators.add(matcher.group(1));
            input = input.substring(matcher.end());
        }
        return input;
    }

    public String[] separateString(final String input) {
        String regex = String.join("|", separators);
        return input.trim().split(regex);
    }

    public Set<String> getSeparators() {
        return separators;
    }
}
