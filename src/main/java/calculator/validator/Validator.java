package calculator.validator;

public class Validator {
    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
    }

    public static void validateDelimiter(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
        if (delimiter.matches(".*\\d.*")) {
            throw new IllegalArgumentException("구분자에 숫자가 포함될 수 없습니다.");
        }
    }

    public static void validateTokens(String[] tokens) {
        for (String token : tokens) {
            if (token.isEmpty() || !token.matches("-?\\d+")) {
                throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
            }
            if (Integer.parseInt(token) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}
