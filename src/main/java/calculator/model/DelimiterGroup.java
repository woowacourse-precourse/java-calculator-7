package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterGroup {

    public static final String BASIC_DELIMITER_COMMA = ",";
    public static final String BASIC_DELIMITER_COLON = ":";
    public static final String WHITE_SPACE = " ";

    public final String EMPTY_STRING = "";
    private final List<String> delimiters = new ArrayList<>();

    public DelimiterGroup(CustomDelimiter customDelimiter) {
        delimiters.add(BASIC_DELIMITER_COMMA);
        delimiters.add(BASIC_DELIMITER_COLON);

        if (customDelimiter.exists()) {
            delimiters.addFirst(customDelimiter.getValue());
        }
    }

    public List<String> split(String input) {
        for (String delimiter : delimiters) {
            input = input.replace(delimiter, WHITE_SPACE);
        }

        checkDelimiterBoundaries(input);

        if (input.equals(EMPTY_STRING)) {
            return List.of("0");
        }

        return Arrays.stream(input.split(WHITE_SPACE)).toList();
    }

    private void checkDelimiterBoundaries(String input) {
        if (input.startsWith(WHITE_SPACE) || input.endsWith(WHITE_SPACE)) {
            throw new IllegalArgumentException("입력값의 시작 또는 끝에 구분자를 사용할 수 없습니다.");
        } else if (input.contains(WHITE_SPACE + WHITE_SPACE)) {
            throw new IllegalArgumentException("구분자를 연속해서 사용할 수 없습니다.");
        }
    }
}
