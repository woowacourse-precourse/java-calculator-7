package calculator.validationRule;

import static calculator.util.Message.잘못된_커스텀_구분자_형식입니다;
import static calculator.util.Token.CUSTOM_TOKEN_PREFIX;
import static calculator.util.Token.NEW_LINE;

public class CustomTokenFormatValidationRule implements ValidationRule {

    @Override
    public void validate(String input) {
        validateInputFormat(input);
        String[] parts = splitInput(input);
        String customToken = extractCustomToken(parts[0]);
        String numbers = parts[1];
        validateNumberFormat(numbers, customToken);
    }

    @Override
    public boolean canHandle(String input) {
        return input.startsWith(CUSTOM_TOKEN_PREFIX) && input.contains(NEW_LINE);
    }

    public void validateInputFormat(String input) {
        if (!canHandle(input)) {
            throw new IllegalArgumentException(잘못된_커스텀_구분자_형식입니다);
        }
    }

    public String[] splitInput(String input) {
        String[] parts = input.split(NEW_LINE, 2);
        if (parts.length != 2 || parts[0].length() != 3) {
            throw new IllegalArgumentException(잘못된_커스텀_구분자_형식입니다);
        }
        return parts;
    }

    public String extractCustomToken(String tokenPart) {
        return tokenPart.substring(CUSTOM_TOKEN_PREFIX.length());
    }

    public void validateNumberFormat(String numbers, String customToken) {
        if (!numbers.matches("^\\d+(" + customToken + "\\d+)*$")) {
            throw new IllegalArgumentException(잘못된_커스텀_구분자_형식입니다);
        }
    }
}
