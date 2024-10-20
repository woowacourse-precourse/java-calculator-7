package calculator.validator;

public class InputStringFormatValidator {
    public static void validate(String inputString) {
        if (!inputString.startsWith("//") && !Character.isDigit(inputString.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: " + inputString);
        }
    }
}
