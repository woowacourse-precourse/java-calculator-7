package calculator;

public class Validator {
    public void validate(String[] numbers) {
        for (String num : numbers) {
            if (!num.matches("\\d*")) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
        }
    }
}
