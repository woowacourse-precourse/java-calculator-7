package parser;

import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 선언 후 개행이 필요합니다.");
            }
            String delimiterPart = input.substring(2, delimiterEndIndex);
            if (delimiterPart.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
            }
            return Pattern.quote(delimiterPart);
        }
        return DEFAULT_DELIMITER_REGEX;
    }
}
