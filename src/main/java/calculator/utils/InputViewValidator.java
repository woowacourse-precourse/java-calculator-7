package calculator.utils;

public class InputViewValidator {

    private static final String ERROR_PREFIX = "Error: ";
    private static final String CUSTOM_NOT_CHAR = ERROR_PREFIX + "커스텀 값에 숫자는 허용하지 않습니다.";

    public void validateCustomNumeric(String customData) {
        if (customData.matches("\\d+")) {
            throw new IllegalArgumentException(CUSTOM_NOT_CHAR);
        }
    }

}