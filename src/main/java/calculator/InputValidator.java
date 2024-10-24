package calculator;

public class InputValidator {

    public void validate(String input) {
        validateNumber(input);
        validateDelimiter(input);
    }

    public void validateDelimiter(String input) {
        for (int i = 1; i < input.length(); i += 2) {
            char delimiter = input.charAt(i);
            if (delimiter != ':' && delimiter != ',') {
                throw new IllegalArgumentException("구분자 입력이 올바르지 않습니다.");
            }
        }
    }

    public void validateNumber(String input) {
        for (int i = 0; i < input.length(); i += 2) {
            char number = input.charAt(i);
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }
            if (Character.getNumericValue(number) < 0) {
                throw new IllegalArgumentException("양수를 입력하세요.");
            }
        }
    }
}
