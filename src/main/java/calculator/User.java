package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private final Pattern customPattern = Pattern.compile(Constants.REGEX_CUSTOM_FORMAT);

    private String userInput;
    private List<String> splitedUserInput;

    public User(String input) {
        this.userInput = input;
        validateUserInput(userInput);
        this.splitedUserInput = splitUserInput(userInput);
    }

    public List<String> getSplitedUserInput() {
        return Collections.unmodifiableList(splitedUserInput);
    }

    private boolean isDefaultFormat(String input) {
        return input.matches(Constants.REGEX_DEFAULT_FORMAT);
    }

    private boolean isCustomFormat(String input) {
        return input.matches(Constants.REGEX_CUSTOM_FORMAT);
    }

    private void validateUserInput(String input) {
        if (!isCustomFormat(input)) {
            validateNumberRange(input);
            validateHasDefaultSeparator(input);
        }
        //throw new IllegalArgumentException(Constants.ERROR_INVALID_VALUES);
    }

    private void validateNumberRange(String input) {
        boolean found = input.matches(Constants.REGEX_FIND_NEGATIVE_NUMBER);
        if (found) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_NUMBER_RANGE);
        }
    }

    private void validateHasDefaultSeparator(String input) {
        boolean had = hasDefaultSeparator(input);
        if (!had) {
            throw new IllegalArgumentException(Constants.ERROR_MISSING_DEFAULT_SEPARATOR);
        }
    }

    private List<String> splitUserInput(String input) {
        if (isDefaultFormat(input)) {
            return defaultSplit(input);
        }
        return customSplit(input);
    }

    private List<String> defaultSplit(String input) {
        return Arrays.asList(input.split(Constants.REGEX_DEFAULT_SEPARATOR, -1));
    }

    private List<String> customSplit(String input) {
        Matcher matcher = customPattern.matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String content = matcher.group(2);
            validateCustomFormatInput(customSeparator, content);
            return Arrays.asList(content.split(Pattern.quote(customSeparator), -1));
        }
        throw new IllegalArgumentException(Constants.ERROR_INVALID_CUSTOM_FORMAT);
    }

    private void validateCustomFormatInput(String separator, String content) {
        if (!separator.equals("-")) {
            validateNumberRange(content);
        }
    }

    private boolean hasDefaultSeparator(String input) {
        return input.matches(Constants.REGEX_FIND_DEFAULT_SEPARATOR);
    }
}
