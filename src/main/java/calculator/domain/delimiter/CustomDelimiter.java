package calculator.domain.delimiter;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM = Pattern.compile("//(.)+\\\\n(.)*");
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";
    private static final int MIN_LENGTH_THRESHOLD = 0;
    private static final int MAX_LENGTH_THRESHOLD = 3;
    private static final String QUOTE_PREFIX = "\\Q";
    private static final String QUOTE_SUFFIX = "\\E";

    private final String input;

    public CustomDelimiter(final String input) {
        this.input = Objects.requireNonNull(input);
    }

    @Override
    public boolean matches() {
        if (CUSTOM.matcher(input)
                .matches()
        ) {
            List<String> splitInput = splitByCustomDelimiterSuffix();
            String customDelimiter = getCustomDelimiter(splitInput);
            return isInRange(customDelimiter);
        }
        return false;
    }

    private boolean isInRange(final String customDelimiter) {
        int customDelimiterLength = getCustomDelimiterLength(customDelimiter);
        return MIN_LENGTH_THRESHOLD <= customDelimiterLength && customDelimiterLength <= MAX_LENGTH_THRESHOLD;
    }

    private int getCustomDelimiterLength(final String customDelimiter) {
        return calculateTotalCharacterCount(customDelimiter) - calculateQuoteAffixCount(customDelimiter);
    }

    private int calculateTotalCharacterCount(final String customDelimiter) {
        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.KOREA);
        breakIterator.setText(customDelimiter);
        int totalCharacterCount = 0;
        while (breakIterator.next() != BreakIterator.DONE) {
            totalCharacterCount++;
        }
        return totalCharacterCount;
    }

    private int calculateQuoteAffixCount(final String customDelimiter) {
        int quoteAffixCount = 0;
        if (customDelimiter.contains(QUOTE_PREFIX)) {
            quoteAffixCount += QUOTE_PREFIX.length();
        }
        if (customDelimiter.contains(QUOTE_SUFFIX)) {
            quoteAffixCount += QUOTE_SUFFIX.length();
        }
        return quoteAffixCount;
    }

    @Override
    public List<String> split() {
        List<String> splitInput = splitByCustomDelimiterSuffix();
        String customDelimiter = getCustomDelimiter(splitInput);
        if (hasOnlyDelimiter(splitInput)) {
            return Collections.emptyList();
        }
        return splitByCustomDelimiter(splitInput.getLast(), customDelimiter);
    }

    private List<String> splitByCustomDelimiterSuffix() {
        return Arrays.stream(input.split(CUSTOM_DELIMITER_SUFFIX))
                .toList();
    }

    private String getCustomDelimiter(final List<String> splitInput) {
        return Pattern.quote(splitInput.getFirst()
                .replaceAll(CUSTOM_DELIMITER_PREFIX, ""));
    }

    private boolean hasOnlyDelimiter(final List<String> numbers) {
        return numbers.size() == 1;
    }

    private List<String> splitByCustomDelimiter(final String numbers, final String customDelimiter) {
        return Arrays.stream(numbers.split(customDelimiter))
                .toList();
    }

}
