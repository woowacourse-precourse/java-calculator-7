package calculator;

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
    public List<Integer> extractNumbers(String input) {
        validate(input);

        String delimiter = extractDelimiter(input);
        // 구분자가 정규식에서 특수 문자일 경우 이스케이프 처리
        String escapedDelimiter = DelimiterUtils.replaceSpecialCharacters(delimiter);

        // 계산을 위한 부분
        String targetString = getTargetPart(input);
        return Arrays.stream(targetString.split(escapedDelimiter))
                .map(DelimiterUtils::removeSpaces)
                .map(Integer::parseInt)
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
            throw new IllegalArgumentException("커스텀 구분자는 // 로 시작해야 한다.");
        }

        if (!input.contains(ESCAPED_DELIMITER_END_POINT)) {
            throw new IllegalArgumentException("커스텀 구분자는 // 로 시작해서 \\n 으로 끝나야 한다.");
        }
    }
}
