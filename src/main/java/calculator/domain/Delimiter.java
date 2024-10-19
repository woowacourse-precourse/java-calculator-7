package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiter {

    private static final Pattern DEFAULT = Pattern.compile("[\\d*,|:?]*");
    private static final Pattern CUSTOM = Pattern.compile("//(.)+\n(.)*");
    private static final String DEFAULT_DELIMITER = "[,|:]";

    public boolean isDefault(final String input) {
        return DEFAULT.matcher(input)
                .matches();
    }

    public boolean isCustom(final String input) {
        return CUSTOM.matcher(input)
                .matches();
    }

    public List<String> split(final String input) {
        if (isCustom(input)) {
            return splitCustom(input);
        }
        if (isDefault(input)) {
            return splitDefault(input);
        }
        throw new IllegalArgumentException();
    }

    private List<String> splitDefault(final String input) {
        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .toList();
    }

    private List<String> splitCustom(final String input) {
        List<String> delimiterAndNumbers = splitByLineFeed(input);
        if (isDefaultNumbers(delimiterAndNumbers)) {
            return Collections.emptyList();
        }
        String customDelimiter = getCustomDelimiter(delimiterAndNumbers);
        return Arrays.stream(delimiterAndNumbers.getLast()
                .split(customDelimiter)
        ).toList();
    }

    private boolean isDefaultNumbers(final List<String> delimiterAndNumbers) {
        return delimiterAndNumbers.size() == 1;
    }

    private List<String> splitByLineFeed(final String input) {
        return input.lines()
                .toList();
    }

    private String getCustomDelimiter(final List<String> delimiterAndNumbers) {
        return delimiterAndNumbers.getFirst()
                .replaceAll("//", "");
    }

}
