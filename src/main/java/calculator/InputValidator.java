package calculator;

public class InputValidator {
    private static final int CUSTOM_DELIMITER_SIZE = 1;

    public static void validateCustomDelimiterFormat(String input) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 선언 형식이 잘못되었습니다.");
        }
    }

    public static void validateCustomDelimiter(String input) {
        if (input.length() != CUSTOM_DELIMITER_SIZE) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
        if (input.matches("[0-9]")) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public static void validateNumbers(String[] inputNumbers) {
        for (String number : inputNumbers) {
            int parsedNumber;
            if (number.isEmpty()) {
                throw new IllegalArgumentException("연속된 구분자의 사용은 허용되지 않습니다.");
            }
            try {
                parsedNumber = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다: " + number);
            }
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수가 포함되어 있습니다: " + number);
            }
        }
    }

}
