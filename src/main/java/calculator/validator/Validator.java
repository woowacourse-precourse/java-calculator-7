package calculator.validator;

public class Validator {
    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
    }

    public static void validateDelimiter(String delimiter) {
        if (delimiter.matches(".*\\d.*")) {
            throw new IllegalArgumentException("구분자에 숫자가 포함될 수 없습니다.");
        }
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
        }
    }

    public static void validateTokens(String[] tokens) {
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("구분자 사이에 숫자가 없습니다.");
            }
        }
    }
}
