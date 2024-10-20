package calculator.validator;

public class InputValidator {

    public void validateNoSpace(String input){
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어있습니다.");
        }
    }

    public void validateIsNumber(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }
}
