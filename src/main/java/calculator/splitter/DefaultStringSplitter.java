package calculator.splitter;

import java.util.regex.Pattern;

public class DefaultStringSplitter implements Splitter {

    private static final String DEFAULT_DELIMITER = ",|:";

    private DefaultStringSplitter() {
    }

    public static DefaultStringSplitter create() {
        return new DefaultStringSplitter();
    }

    @Override
    public String[] split(String input) {
        String delimiterPattern = DEFAULT_DELIMITER;
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterStart = input.indexOf("//") + 2;
            int delimiterEnd = input.indexOf("\\n");

            if (delimiterEnd == -1 || delimiterStart >= delimiterEnd) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }

            String customDelimiter = input.substring(delimiterStart, delimiterEnd);
            delimiterPattern = createDelimiterPattern(customDelimiter);
            numbers = input.substring(delimiterEnd + 2);
        }
        return numbers.split(delimiterPattern);
    }

    private String createDelimiterPattern(String customDelimiter) {
        StringBuilder patternBuilder = new StringBuilder();

        for (char delimiter : customDelimiter.toCharArray()) {
            if (!patternBuilder.isEmpty()) {
                patternBuilder.append("|");
            }
            patternBuilder.append(Pattern.quote(String.valueOf(delimiter)));
        }

        if (!patternBuilder.isEmpty()) {
            patternBuilder.append("|").append(DEFAULT_DELIMITER);
        }
        return patternBuilder.toString();
    }
}
