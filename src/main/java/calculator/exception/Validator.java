package calculator.exception;

public class Validator {
    public static void validateInput(String input, String separator) {
        if (input.isEmpty()) {
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' && i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                continue;
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) && separator.indexOf(c) == -1) {
                throw new IllegalArgumentException("구분자가 아닌 값이 있습니다: " + c);
            }
        }
    }

    public static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
