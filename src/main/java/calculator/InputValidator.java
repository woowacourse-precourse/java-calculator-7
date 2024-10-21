package calculator;

public class InputValidator {

    public void validateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값 입력됨. 다시 실행하시오.");
        }
    }

    public int positiveNumber(Integer input) {
        if (input <= 0) {
            throw new IllegalArgumentException("양수 외에 불가. 다시 실행하시오.");
        }
        return input;
    }
}
