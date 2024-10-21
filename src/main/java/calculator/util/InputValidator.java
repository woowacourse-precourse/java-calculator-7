package calculator.util;

import java.util.List;
public class InputValidator {

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String NEW_LINE = "\n";
    private static final int MAX_CUSTOM_DELIMITER_LENGTH = 1;

    // 문자열이 올바른 형식인지 검증하는 메서드
    public static void validateStringFormat(String input) {
        if (isEmptyInput(input)) {
            return;  // 빈 문자열은 0으로 처리됨
        }

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
        if (!input.contains(NEW_LINE)) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자와 숫자 부분을 구분하는 \\n이 필요합니다.");
        }

        String delimiterPart = input.substring(2, input.indexOf(NEW_LINE));
        validateCustomDelimiterLength(delimiterPart);
    }

    // 커스텀 구분자의 길이가 1자인지 확인
    private static void validateCustomDelimiterLength(String delimiterPart) {
        if (delimiterPart.length() > MAX_CUSTOM_DELIMITER_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
    }

    // 입력값이 음수인지 검증하는 메서드
    public static void validateNegativeNumbers(List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int num = Integer.parseInt(numbers.get(i));
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
        }
    }
}