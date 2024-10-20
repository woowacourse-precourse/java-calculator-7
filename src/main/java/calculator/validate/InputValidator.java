package calculator.validate;

public class InputValidator {

    public void validateCustomInputFormat(String input) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("입력 문자열에 \\n이 포함되어 있지 않습니다.");
        }
    }

    public void validateCustomEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 공백입니다.");
        }
    }

    public void validateCustomSize(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException("커스텀 구분자의 최대 길이는 2입니다.");
        }
    }

    public void validateNumberInCustom(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("커스텀 구분자 내에 숫자가 포함되어 있습니다.");
            }
        }
    }
}
