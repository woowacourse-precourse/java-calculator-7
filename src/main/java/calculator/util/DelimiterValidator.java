package calculator.util;

public class DelimiterValidator {
    private static final int validLength = 1;
    private static final int typeErrorCustomDelimiter = -1;

    public static void afterFindCustomDelimiter(String input) {
        if (input.length() != validLength || input.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 허용됩니다.");
        }

        if (Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public static void checkTypeOfCustomDelimiter(int input) {
        if (input == typeErrorCustomDelimiter) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자가 아닙니다.");
        }
    }
}
