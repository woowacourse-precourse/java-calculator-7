package calculator.validator;

public class ValidationUtils {
    public static void validateStartWithDoubleSlash(String inputString) {
        if (!inputString.startsWith("//") && !Character.isDigit(inputString.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: " + inputString);
        }
    }
}
