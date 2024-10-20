package calculator;

public class InputValidation {
    public static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력한 값이 없습니다. 확인 후 다시 입력해주세요.");
        }
    }
}
