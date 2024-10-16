package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Decoder {

    private static final String DELIMITER_START = "//";
    private static final String DELIMITER_END = "\n";
    private static final String DEFAULT_DELIMITER = ",:";
    private final List<Integer> decodedNumbers;

    public Decoder(String input) {
        decodedNumbers = decode(input);
    }

    private List<Integer> decode(String input) {
        if (hasCustomDelimiter(input)) {
            return separateByDelimiter(findStringToAdd(input), findCustomDelimiter(input));
        }
        return separateByDelimiter(input, DEFAULT_DELIMITER);
    }

    // 입력값이 "//"로 시작하고 "\n"을 포함하는 지 확인
    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(DELIMITER_START) && input.contains(DELIMITER_END);
    }

    private String findStringToAdd(String input) {
        return input.substring(input.indexOf(DELIMITER_END) + 1);
    }

    // 커스텀 구분자 찾기
    private String findCustomDelimiter(String input) {
        String delimiter = input.substring(input.indexOf(DELIMITER_START) + 2, input.indexOf(DELIMITER_END));
        // 유효성 검사
        validateDelimiterIsBlank(delimiter);
        validateDelimiterIsNumber(delimiter);
        return delimiter;
    }

    // 커스텀 구분자가 비어있는지 확인
    private void validateDelimiterIsBlank(String delimiter) {
        if(delimiter.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    // 커스텀 구분자가 숫자인지 확인
    private void validateDelimiterIsNumber(String delimiter) {
        try {
            Integer.parseInt(delimiter);
            throw new IllegalArgumentException();
        } catch (NumberFormatException ignored) {

        }
    }

    // 덧셈할 숫자 뽑기
    private List<Integer> separateByDelimiter(String input, String delimiter) {
        List<Integer> numbers = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(input, delimiter);
        while(st.hasMoreTokens()) {
            numbers.add(validateNumber(st.nextToken()));
        }
        return numbers;
    }

    private int validateNumber(String s) {
        try {
            int number = Integer.parseInt(s);
            if(number >= 0) {
                return number;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getDecodedNumbers() {
        return decodedNumbers;
    }
}
