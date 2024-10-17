package calculator.model;

import static calculator.exception.ErrorMessage.INVALID_INPUT;
import static calculator.exception.ErrorMessage.NEGATIVE_NUMBER;
import static calculator.exception.ErrorMessage.NULL_OR_EMPTY_INPUT;

import java.util.Arrays;

public class DelimiterCalculator {

    private static final String DELIMITER_REGEX = "[,:]";

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

        String[] parts = splitInput(input);

        return Arrays.stream(parts)
                .mapToInt(this::parseNumber)
                .sum();
    }


    /**
     * 커스텀 구분자 존재 여부 판단 -> 구분자에 따라 split
     *
     * @param input 사용자의 입력 값
     * @return String 배열 : 숫자
     */
    private String[] splitInput(String input) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiter = parts[0].substring(2);
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
