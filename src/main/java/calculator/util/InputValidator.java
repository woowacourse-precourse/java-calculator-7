package calculator.util;

public class InputValidator {

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String NEW_LINE = "\n";
    private static final int MAX_CUSTOM_DELIMITER_LENGTH = 1;

    // 문자열이 올바른 형식인지 검증하는 메서드
    public static void validateStringFormat(String input) {
        if (isEmptyInput(input)) {
            return;
        }
    }

    // 커스텀 구분자가 올바른 형식인지 검증하는 메서드
    public static void validateCustomDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            validateCustomDelimiterFormat(input);
        }
    }

    // 입력된 문자열이 빈 값인지 확인
    private static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    // 커스텀 구분자가 있는지 확인
    private static boolean isCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START);
    }

    // 커스텀 구분자가 올바른 형식인지 확인
    private static void validateCustomDelimiterFormat(String input) {
        String[] parts = input.split(NEW_LINE, 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }

        String delimiterPart = parts[0].substring(2);  // "//" 뒤의 구분자 부분 추출
        validateCustomDelimiterLength(delimiterPart);
    }

    // 커스텀 구분자의 길이가 1인지 확인
    private static void validateCustomDelimiterLength(String delimiterPart) {
        if (delimiterPart.length() > MAX_CUSTOM_DELIMITER_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
    }
}