package calculator.domain;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class Delimiter {

    private static final Pattern DEFAULT = Pattern.compile("[\\d*(,|:)?]*");
    private static final Pattern CUSTOM = Pattern.compile("//(.)+\\\\n(.)*");
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\\\n";

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
        List<String> delimiterAndNumbers = splitByCustomDelimiterEnd(input);
        String customDelimiter = getCustomDelimiter(delimiterAndNumbers);
        validateCustomDelimiterLength(customDelimiter);
        if (isNumbersEmpty(delimiterAndNumbers)) {
            return Collections.emptyList();
        }
        return splitByCustomDelimiter(delimiterAndNumbers.getLast(), customDelimiter);
    }

    private List<String> splitByCustomDelimiterEnd(final String input) {
        return Arrays.stream(input.split(CUSTOM_DELIMITER_END))
                .toList();
    }

    private String getCustomDelimiter(final List<String> delimiterAndNumbers) {
        return Pattern.quote(delimiterAndNumbers.getFirst()
                .replaceAll(CUSTOM_DELIMITER_START, ""));
    }

    private void validateCustomDelimiterLength(final String customDelimiter) {
        int wordCount = getCustomDelimiterLength(customDelimiter);
        if (wordCount < 0 || wordCount > 3) {
            throw new IllegalArgumentException();
        }
    }

    private int getCustomDelimiterLength(final String customDelimiter) {
        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.KOREA);
        breakIterator.setText(customDelimiter);
        int wordCount = 0;
        while (breakIterator.next() != BreakIterator.DONE) {
            wordCount++;
        }
        if (customDelimiter.contains("\\Q")) {
            wordCount -= 2;
        }
        if (customDelimiter.contains("\\E")) {
            wordCount -= 2;
        }
        return wordCount;
    }

    private boolean isNumbersEmpty(final List<String> numbers) {
        return numbers.size() == 1;
    }

    private List<String> splitByCustomDelimiter(final String numbers, final String customDelimiter) {
        return Arrays.stream(numbers.split(customDelimiter))
                .toList();
    }

}
