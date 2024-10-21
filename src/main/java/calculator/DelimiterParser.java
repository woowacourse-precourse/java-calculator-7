package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterParser {
    private static final String PREFIX_SPECIAL_DELIMITER = "//";
    private static final String SUFFIX_SPECIAL_DELIMITER = "\\n";
    private static final char COMMA_BASIC_DELIMITER = ',';
    private static final char COLON_BASIC_DELIMITER = ':';
    private static final int EXPECTED_SPECIAL_DELIMITER_LENGTH = 3;

    public List<Character> parseDelimiter(String userInput) {
        List<Character> delimiter = new ArrayList<>();

        addBasicDelimiter(delimiter);
        addSpecialDelimiter(delimiter, userInput);

        return delimiter;
    }

    private void addSpecialDelimiter(List<Character> delimiter, String userInput) {
        StringBuilder delimiterBuilder = new StringBuilder(userInput);
        int start = delimiterBuilder.indexOf(PREFIX_SPECIAL_DELIMITER);
        int end = delimiterBuilder.indexOf(SUFFIX_SPECIAL_DELIMITER);

        if (start == -1 || end == -1) {
            return;
        }

        if (end - start == EXPECTED_SPECIAL_DELIMITER_LENGTH) {
            delimiter.add(delimiterBuilder.charAt(end - 1));
        } else {
            throw new IllegalArgumentException("커스텀 구분자는 문자열이 아닌 문자여야 합니다.");
        }
    }

    private void addBasicDelimiter(List<Character> delimiter) {
        delimiter.add(COMMA_BASIC_DELIMITER);
        delimiter.add(COLON_BASIC_DELIMITER);
    }

    public String parseMarker(String userInput) {
        StringBuilder delimiterBuilder = new StringBuilder(userInput);
        int start = delimiterBuilder.indexOf(PREFIX_SPECIAL_DELIMITER);
        int end = delimiterBuilder.indexOf(SUFFIX_SPECIAL_DELIMITER);

        if (start == -1 || end == -1) {
            return userInput;
        }

        String parsedUserInput = delimiterBuilder.substring(0, start) + delimiterBuilder.substring(end + 2);

        return parsedUserInput;
    }
}
