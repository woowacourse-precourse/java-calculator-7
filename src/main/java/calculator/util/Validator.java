package calculator.util;

public class Validator {

    public static boolean isValidate(String input) {

        // 문자열이 빈 경우
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
            // unchecked exception
        }

        // 문자열에 숫자가 없는 경우
        if (!input.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        return true;
    }
}
