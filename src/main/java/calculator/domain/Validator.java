package calculator.domain;

import java.util.List;

public class Validator {
    public static final String INVALID_DELIMITER_MSG = "잘못된 커스텀 구분자 형식입니다.";
    public static final String INVALID_INPUT_MSG = "입력값이 존재하지 않습니다.";
    public static final String INVALID_NUMBER_MSG = "모든 값은 정수여야 합니다.";
    public static final String NEGATIVE_NUMBER_MSG = "모든 숫자는 양수여야 합니다.";

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MSG);
        }
    }
    public void validateCustomDelimiter(String input){
        if (input.startsWith("//")) {
            throw new IllegalArgumentException(INVALID_DELIMITER_MSG);
        }
    }
    public void validateIsInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MSG, e);
        }
    }
    public void validateAllPositive(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 0)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MSG);
        }
    }

}
