package calculator.model;

public class InputValidator {
    public void validate(String[] numbers) {
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number.trim()); // 숫자 이외의 값 검사
                if (num < 0) {
                    throw new IllegalArgumentException("음수 값이 포함되어 있습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }
}
