package calculator.model;

import calculator.constant.DefaultDelimiter;
import calculator.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSeparator {
    private static final int CUSTOM_DELIMITER_POSITION = 1;
    private static final int EQUATION_POSITION = 2;

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n(.*?)$");

    private final String equation;
    private final List<Delimiter> delimiters = new ArrayList<>();

    private NumberSeparator(String input) {
        delimiters.addAll(DefaultDelimiter.getDefaultDelimiter());

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
        DefaultDelimiter.getDefaultDelimiter().stream()
                .filter(defaultDelimiter -> defaultDelimiter.equals(delimiter))
                .findAny()
                .ifPresent(matched -> {
                    throw new IllegalArgumentException(
                            ErrorMessage.NUMBER_SEPARATOR_CUSTOM_DELIMITER_MUST_NOT_DEFAULT.getMessage());
                });
    }

    private Matcher getMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private Delimiter extractCustomDelimiter(Matcher matcher) {
        Delimiter customDelimiter = Delimiter.from(
                matcher.group(CUSTOM_DELIMITER_POSITION)
        );

        validateNotDefaultDelimiter(customDelimiter);

        return customDelimiter;
    }

    private String extractEquation(Matcher matcher) {
        return matcher.group(EQUATION_POSITION).trim();
    }

    public Numbers separate() {
        if (equation.isEmpty()) {
            return Numbers.parseNumbers(
                    new ArrayList<>()
            );
        }

        return Numbers.parseNumbers(
                Arrays.stream(
                        equation.split(Delimiter.toRegex(delimiters))
                ).map(String::trim).toList()
        );
    }
}