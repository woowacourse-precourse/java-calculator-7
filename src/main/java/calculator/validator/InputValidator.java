package calculator.validator;

public class InputValidator {

    public static void validateInput(String inputString) {
        containNegative(inputString);
    }

    private static void containNegative(String inputString) {
        if (!inputString.startsWith("//-\n")) {
            if (inputString.contains("-")) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}
