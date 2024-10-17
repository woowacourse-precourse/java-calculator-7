package calculator.validator;

public class InputValidator {


    public void validateEmptyOrNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 빈 문자열 또는 null 입력은 허용되지 않습니다.");
        }
    }

    public void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }

    public String[] splitInput(String input) {
        input = input.replace("\\n", "\n");
        String[] parts = input.split("\n", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: 계산 될 문자가 없습니다.");
        }
        return parts;
    }
}
