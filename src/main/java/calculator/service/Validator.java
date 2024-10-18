package calculator.service;

public class Validator {

    public void validate(String[] numbers) {
        for (String num : numbers) {
            if (!num.matches("\\d+")) {
                throw new IllegalArgumentException("올바르지 않은 숫자 형식입니다: " + num);
            }
        }
    }
}
