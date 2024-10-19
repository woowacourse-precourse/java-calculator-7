package calculator.model;

import static calculator.exception.ErrorMessage.CONSECUTIVE_DELIMITERS;
import static calculator.exception.ErrorMessage.INVALID_INPUT;
import static calculator.exception.ErrorMessage.NEGATIVE_NUMBER;
import static calculator.exception.ErrorMessage.NULL_OR_EMPTY_INPUT;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DelimiterCalculator {

    private static final String DELIMITER_REGEX = "[,:]";
    private static final Pattern INVALID_DEFAULT_INPUT_PATTERN = Pattern.compile("[^0-9,:]");
    private static final Pattern CONSECUTIVE_DELIMITER_PATTERN = Pattern.compile("(,|:){2,}");

    /**
     * 사용자의 입력 값을 기반으로 계산
     *
     * @param input 사용자의 입력 값
     * @return 계산된 결과 값
     * @throws IllegalArgumentException : NULL_OR_EMPTY_INPUT
     */
    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT);
        }

        input = input.replace(" ", "");

        if (isUsingDefaultDelimiter(input)) {
            validateDefaultInput(input);
        }

        String[] parts = splitInput(input);

        return Arrays.stream(parts)
                .mapToInt(this::parseNumber)
                .sum();
    }

    /**
     * 기본 구분자 사용 여부 판단
     *
     * @param input 사용자의 입력 값
     * @return 기본 구분자 사용 여부
     */
    private boolean isUsingDefaultDelimiter(String input) {
        return !input.startsWith("//");
    }

    /**
     * 기본 구분자를 사용하는 입력 값 검증 : 숫자와 기본 구분자로만 이루어진 문자열인지, 구분자를 연속으로 사용하지 않는지 판단
     *
     * @param input 사용자의 입력 값
     * @throws IllegalArgumentException : INVALID_INPUT, CONSECUTIVE_DELIMITERS
     */
    private void validateDefaultInput(String input) {
        if (INVALID_DEFAULT_INPUT_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        if (CONSECUTIVE_DELIMITER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(CONSECUTIVE_DELIMITERS);
        }
    }

    /**
     * 커스텀 구분자 존재 여부 판단 -> 구분자에 따라 split
     *
     * @param input 사용자의 입력 값
     * @return String 배열 : 숫자
     */
    private String[] splitInput(String input) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n");
            String delimiter = parts[0].substring(2);

            if (delimiter.length() > 1) {
                delimiter = "[" + delimiter + "]";
            }

            return parts[1].split(delimiter);
        }

        return input.split(DELIMITER_REGEX);
    }

    /**
     * String -> int 변환
     *
     * @param part String 값
     * @return 변환된 int 값
     * @throws IllegalArgumentException : NEGATIVE_NUMBER, INVALID_INPUT
     */
    private int parseNumber(String part) {
        try {
            int num = Integer.parseInt(part);

            if (num < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER);
            }

            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

}
