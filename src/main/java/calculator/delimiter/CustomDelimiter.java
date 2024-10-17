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
    public boolean applicable(String rawInput) {
        if (!rawInput.startsWith(DELIMITER_START_POINT)) {
            return false;
        }

        return rawInput.contains(ESCAPED_DELIMITER_END_POINT);
    }

    @Override
    public List<String> extractString(String rawInput) {
        validate(rawInput);

        String delimiter = extractDelimiter(rawInput);

        // " " 가 아닌, "" 로 완전히 비어있을 때는 예외이다.
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING_IS_NOT_ALLOWED.getMessage());
        }

        // 구분자가 정규식에서 특수 문자일 경우 이스케이프 처리
        String escapedDelimiter = DelimiterUtils.replaceSpecialCharacters(delimiter);

        String targetString = getTargetPart(rawInput);
        return Arrays.stream(targetString.split(escapedDelimiter))
                .toList();
    }

    private String getTargetPart(String rawInput) {
        int delimiterEndPosition = rawInput.indexOf(ESCAPED_DELIMITER_END_POINT);
        return rawInput.substring(delimiterEndPosition + 2);
    }

    private String extractDelimiter(String rawInput) {
        return rawInput.substring(DELIMITER_START_POINT.length(), rawInput.indexOf(ESCAPED_DELIMITER_END_POINT));
    }

    private void validate(String rawInput) {
        if (!rawInput.startsWith(DELIMITER_START_POINT)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_START_POINT_NOT_ALLOWED.getMessage());
        }

        if (!rawInput.contains(ESCAPED_DELIMITER_END_POINT)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_END_POINT_NOT_ALLOWED.getMessage());
        }
    }
}
