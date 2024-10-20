package calculator.delimiter;

import calculator.command.DelimiterLine;

public class DelimiterReader {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public Delimiter readDelimiter(String line) {
        if(hasNoDelimiterOption(line))
            return Delimiter.DEFAULT_DELIMITER;
        if(hasNoPrefix(line) || hasNoSuffix(line))
            throw new IllegalArgumentException("잘못된 형식의 구분자 입력");

        String delimiterLine = getDelimiterLine(line);
        String delimiter = removeWords(delimiterLine, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
        return Delimiter.create(new DelimiterLine(delimiter));
    }

    private boolean hasNoDelimiterOption(String line) {
        return hasNoPrefix(line) && hasNoSuffix(line);
    }

    private static boolean hasNoSuffix(String line) {
        return !line.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private static boolean hasNoPrefix(String line) {
        return !line.contains(CUSTOM_DELIMITER_PREFIX);
    }

    private String removeWords(String original, String... words) {
        String result = original;
        for (String word : words) {
            result = result.replace(word, "");
        }
        return result;
    }

    private String getDelimiterLine(String line) {
        return line.substring(0, findEndOfDelimiterLineIndex(line));
    }

    private int findEndOfDelimiterLineIndex(String line) {
        return line.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
    }
}
