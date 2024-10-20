package calculator.model;

import java.util.List;
import java.util.stream.Stream;

public class ExtractLogic {
    private static final String CUSTOM_DELIMITER_REGEX = "//"; //커스텀 구분자 접두사
    private static final int CUSTOM_DELIMITER_INDEX = 2; // 커스텀 구분자 위치 인덱스
    private static final String DEFAULT_DELIMITER = ",|:"; // 기본 구분자
    private static final String NUMBER_PATTERN_REGEX = "^[0-9]+$";

    public String extractDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_REGEX)) {
            return String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
        }
        return DEFAULT_DELIMITER;
    }

    public List<Integer> extractNumber(String input, String delimiter) {
        if (input.matches(NUMBER_PATTERN_REGEX)) { //
            return List.of(Integer.parseInt(input));
        }
        String[] numberList = input.split(delimiter);
        return Stream.of(numberList)
                .map(Integer::parseInt)
                .toList();
    }
}
