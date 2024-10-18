package calculator.validation.customSeparator;

import calculator.validation.ErrorMesaage;

public class CustomSeparatorNumberValidation {
    private CustomSeparatorNumberValidation() {
    }

    public static void validate(String inputString) {
        if(Character.isDigit(inputString.charAt(2))) {
            throw new IllegalArgumentException(ErrorMesaage.CUSTOM_SEPARATOR_NUMBER.getMessage());
        }
    }
}