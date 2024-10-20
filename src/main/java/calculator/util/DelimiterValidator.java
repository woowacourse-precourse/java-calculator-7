package calculator.util;

public class DelimiterValidator {
    public static void afterFindCustomDelimiter(String input) {
        if (input.length() != 1 || input.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 허용됩니다.");
        }

        if (Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public static void checkTypeOfCustomDelimiter(int input) {
        if (input == -1) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자가 아닙니다.");
        }
    }
}
