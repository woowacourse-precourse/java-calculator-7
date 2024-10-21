package calculator.domain;

public class Validator {
    public static final String INVALID_DELIMITER_MSG = "잘못된 커스텀 구분자 형식입니다.";
    public static final String INVALID_INPUT_MSG = "입력값이 존재하지 않습니다.";

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

}
