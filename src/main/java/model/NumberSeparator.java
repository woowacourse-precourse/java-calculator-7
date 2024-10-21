package model;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSeparator {
    private static final String NUMBER_PATTERN = "^-?[0-9]+$";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n(.*?)$");
    private static final String DEFAULT_OPERATION = ",|:";
    private final List<Delimiter> delimiters = new ArrayList<>();
    private String equation;

    /**
     * 구분자에 따라 문자열을 분리하는 함수
     **/
    private NumberSeparator(String input) {
        delimiters.addAll(Delimiter.getDefaultDelimiter());

        Matcher matcher = getMatcher(input);
        if (hasCustomDelimiter(matcher)) {
            delimiters.add(extractCustomDelimiter(matcher));
            equation = extractEquation(matcher);
            return;
        }

        equation = input;
    }

    public static NumberSeparator from(String input) {
        return new NumberSeparator(input);
    }

    private void validateNotDefaultDelimiter(Delimiter delimiter) {
        Delimiter.getDefaultDelimiter().stream()
                .filter(defaultDelimiter -> defaultDelimiter.equals(delimiter))
                .findAny()
                .ifPresent(matched -> {
                    throw new IllegalArgumentException(
                            ErrorMessage.DUPLICATE_WITH_DEFAULT_DELIMITER.getMessage());
                });
    }

    private Matcher getMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private Delimiter extractCustomDelimiter(Matcher matcher) {
        Delimiter customDelimiter = Delimiter.from(matcher.group(1));
        validateNotDefaultDelimiter(customDelimiter);
        return customDelimiter;
    }

    private String extractEquation(Matcher matcher) {
        return matcher.group(2).trim();
    }

    public Numbers separate() {
        if (equation == null ||equation.isEmpty()) {
            return Numbers.parseNumbers(new ArrayList<>());
        }

        return Numbers.parseNumbers(
                Arrays.stream(
                        equation.split(Delimiter.toRegex(delimiters))
                ).map(String::trim).toList()
        );
    }
}
