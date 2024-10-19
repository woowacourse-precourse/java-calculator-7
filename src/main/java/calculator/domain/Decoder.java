package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Decoder {

    private static final String DELIMITER_START = "//";
    private static final String DELIMITER_END = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private final List<Integer> decodedNumbers;

    public Decoder(String input) {
        decodedNumbers = new LinkedList<>();
        decode(input);
    }

    private void decode(String input) {
        if (hasCustomDelimiter(input)) {
            collectNumbers(findEncodedString(input), findCustomDelimiter(input));
            return;
        }
        collectNumbers(input, DEFAULT_DELIMITER);
    }

    // 입력값이 "//"로 시작하고 "\n"을 포함하는 지 확인
    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(DELIMITER_START) && input.contains(DELIMITER_END);
    }

    private String findEncodedString(String input) {
        int start = input.indexOf(DELIMITER_END) + DELIMITER_END.length();
        return input.substring(start);
    }

    // 커스텀 구분자 찾기
    private String findCustomDelimiter(String input) {
        int start = DELIMITER_START.length();
        int end = input.indexOf(DELIMITER_END);
        String customDelimiter = input.substring(start, end);
        // 유효성 검사
        validateCustomDelimiter(customDelimiter);
        return Pattern.quote(customDelimiter);
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (isBlank(customDelimiter) || isInt(customDelimiter)) {
            throw new IllegalArgumentException();
        }
    }

    // 커스텀 구분자가 비어있는지 확인
    private boolean isBlank(String customDelimiter) {
        return customDelimiter.isBlank();
    }

    // 커스텀 구분자가 숫자인지 확인
    private boolean isInt(String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 덧셈할 숫자 뽑기
    private void collectNumbers(String encodedString, String delimiter) {
        String[] tokens = encodedString.split(delimiter);
        for (String t : tokens) {
            if (t.isBlank()) {
                continue;
            }
            try {
                int number = Integer.parseInt(t);
                validateNumber(number);
                decodedNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumber(int number) {
        if (isNegativeInt(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNegativeInt(int number) {
        return number < 0;
    }

    public List<Integer> getDecodedNumbers() {
        return decodedNumbers;
    }
}
