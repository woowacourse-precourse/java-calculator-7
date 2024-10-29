package calculator.validation;

import calculator.model.dto.SeparatorDto;

public class NotAllowedInputValidation {
    private NotAllowedInputValidation() {
    }

    public static void validate(String inputString) {
        SeparatorDto separatorDto = SeparatorDto.getInstance();
        for (int i = 0; i < inputString.length(); i++) {
            char inputElement = inputString.charAt(i);
            if (!Character.isDigit(inputElement)&& !separatorDto.isContainSeparator(inputElement)) {
                throw new IllegalArgumentException(ErrorMesaage.NOT_ALLOWED_INPUT.getMessage());
            }
        }
    }
}
