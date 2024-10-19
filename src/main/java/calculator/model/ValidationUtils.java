package calculator.model;


public class ValidationUtils {
    public void validateInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private boolean isEmpty(String input) {
        return input.isEmpty();
    }
}
