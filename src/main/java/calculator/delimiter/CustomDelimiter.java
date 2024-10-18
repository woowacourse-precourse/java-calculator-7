package calculator.delimiter;

import calculator.calculator.Delimiter;
import calculator.utils.DelimiterUtils;
import calculator.utils.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class CustomDelimiter implements Delimiter {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    @Override
    public boolean applicable(String rawInput) {
        if (!rawInput.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return false;
        }

        return rawInput.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    @Override
    public List<String> tokenize(String rawInput) {
        String delimiter = extractDelimiter(rawInput);

        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING_IS_NOT_ALLOWED.getMessage());
        }

        // 구분자가 정규식에서 특수 문자일 경우 이스케이프 처리
        String escapedDelimiter = DelimiterUtils.replaceSpecialCharacters(delimiter);
        String contentPart = extractContent(rawInput);

        return Arrays.stream(contentPart.split(escapedDelimiter))
                .toList();
    }

    private String extractContent(String rawInput) {
        int delimiterEndPosition = rawInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return rawInput.substring(delimiterEndPosition + 2);
    }

    private String extractDelimiter(String rawInput) {
        return rawInput.substring(CUSTOM_DELIMITER_PREFIX.length(), rawInput.indexOf(CUSTOM_DELIMITER_SUFFIX));
    }

}
