package calculator.domain;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM = Pattern.compile("//(.)+\\\\n(.)*");
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\\\n";
    private static final int MIN_LENGTH_THRESHOLD = 0;
    private static final int MAX_LENGTH_THRESHOLD = 3;
    private static final String QUOTE_START = "\\Q";
    private static final String QUOTE_END = "\\E";

    private final String input;

    public CustomDelimiter(final String input) {
        this.input = input;
    }

    @Override
    public boolean matches() {
        if (CUSTOM.matcher(input)
                .matches()
        ) {
            List<String> splitInput = splitByCustomDelimiterEnd();
            String customDelimiter = getCustomDelimiter(splitInput);
            return isInRange(customDelimiter);
        }
        return false;
    }

    private boolean isInRange(final String customDelimiter) {
        int wordCount = getCustomDelimiterLength(customDelimiter);
        return MIN_LENGTH_THRESHOLD <= wordCount && wordCount <= MAX_LENGTH_THRESHOLD;
    }

    @Override
    public List<String> split() {
        List<String> splitInput = splitByCustomDelimiterEnd();
        String customDelimiter = getCustomDelimiter(splitInput);
        if (hasOnlyDelimiter(splitInput)) {
            return Collections.emptyList();
        }
        return splitByCustomDelimiter(splitInput.getLast(), customDelimiter);
    }

    private List<String> splitByCustomDelimiterEnd() {
        return Arrays.stream(input.split(CUSTOM_DELIMITER_END))
                .toList();
    }

    private String getCustomDelimiter(final List<String> splitInput) {
        return Pattern.quote(splitInput.getFirst()
                .replaceAll(CUSTOM_DELIMITER_START, ""));
    }

    private int getCustomDelimiterLength(final String customDelimiter) {
        return calculateTotalCount(customDelimiter) - calculateQuoteCount(customDelimiter);
    }

    private int calculateTotalCount(final String customDelimiter) {
        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.KOREA);
        breakIterator.setText(customDelimiter);
        int totalWordCount = 0;
        while (breakIterator.next() != BreakIterator.DONE) {
            totalWordCount++;
        }
        return totalWordCount;
    }

    private int calculateQuoteCount(final String customDelimiter) {
        int quoteCount = 0;
        if (customDelimiter.contains(QUOTE_START)) {
            quoteCount += QUOTE_START.length();
        }
        if (customDelimiter.contains(QUOTE_END)) {
            quoteCount += QUOTE_END.length();
        }
        return quoteCount;
    }

    private boolean hasOnlyDelimiter(final List<String> numbers) {
        return numbers.size() == 1;
    }

    private List<String> splitByCustomDelimiter(final String numbers, final String customDelimiter) {
        return Arrays.stream(numbers.split(customDelimiter))
                .toList();
    }

}
