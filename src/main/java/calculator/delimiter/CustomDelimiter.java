package calculator.delimiter;

import calculator.calculator.Delimiter;
import calculator.utils.DelimiterUtils;
import calculator.utils.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class CustomDelimiter implements Delimiter {

    private static final String DELIMITER_START_POINT = "//";

    private static final String ESCAPED_DELIMITER_END_POINT = "\\n";

    @Override
    public boolean applicable(String input) {
        if (!input.startsWith(DELIMITER_START_POINT)) {
            return false;
        }

        return input.contains(ESCAPED_DELIMITER_END_POINT);
    }

    @Override
    public List<String> extractString(String input) {
        validate(input);

        String delimiter = extractDelimiter(input);
        // 구분자가 정규식에서 특수 문자일 경우 이스케이프 처리
        String escapedDelimiter = DelimiterUtils.replaceSpecialCharacters(delimiter);

        String targetString = getTargetPart(input);
        return Arrays.stream(targetString.split(escapedDelimiter))
                .toList();
    }

    private String getTargetPart(String input) {
        int delimiterEndPosition = input.indexOf(ESCAPED_DELIMITER_END_POINT);
        return input.substring(delimiterEndPosition + 2);
    }

    private String extractDelimiter(String input) {
        return input.substring(DELIMITER_START_POINT.length(), input.indexOf(ESCAPED_DELIMITER_END_POINT));
    }

    private void validate(String input) {
        if (!input.startsWith(DELIMITER_START_POINT)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_START_POINT_NOT_ALLOWED.getMessage());
        }

        if (!input.contains(ESCAPED_DELIMITER_END_POINT)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_END_POINT_NOT_ALLOWED.getMessage());
        }
    }
}
