package utils;

public class InputViewValidator {

    private static final String ERROR_PREFIX = "Error: ";
    private static final String INPUT_NO_QUOTATION_PAIR = ERROR_PREFIX + "입력에 큰 따음표로 감싸져있지 않습니다.";
    private static final String CUSTOM_NOT_CHAR = ERROR_PREFIX + "커스텀 값에 숫자는 허용하지 않습니다.";

    public void validateQuotationPair(String inputName) {
        if (inputName == null || !inputName.startsWith("\"") || !inputName.endsWith("\"")) {
            throw new IllegalArgumentException(INPUT_NO_QUOTATION_PAIR);
        }
    }


    public void validateCustomNumeric(String customData) {
        if (customData.matches("\\d+")) {
            throw new IllegalArgumentException(CUSTOM_NOT_CHAR);
        }
    }

}