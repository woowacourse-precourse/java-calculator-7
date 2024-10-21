package calculator.util;

public class StringValidator {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DELIMITER_END = "\\n";

    // 입력값의 유효성을 검사하고, 구분자를 반환하는 메서드
    public String isValid(String input) {
        // 공백일시 기본 구분자 반환
        if (input == null || input.trim().isEmpty()) {
            return DEFAULT_DELIMITERS; // 구분자 없이 숫자 "0"을 반환할 수 있도록 기본 구분자 반환
        }

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.indexOf(DELIMITER_END);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 구분자 정의가 없습니다.");
            }

            String customDelimiter = input.substring(2, delimiterEndIndex);

            // 커스텀 구분자가 없는 경우
            if (customDelimiter.isEmpty()) {
                return "";
            }

            // 여러 개의 구분자를 허용하는 경우 정규식으로 처리
            return "[" + customDelimiter + "]";
        }

        // 기본 구분자를 사용하여 유효성 검사 후 반환
        return DEFAULT_DELIMITERS;
    }

    // 숫자 리스트가 유효한지 확인하는 메서드 (예: 음수 확인)
    public void validateNumbers(String[] numbers) {
        for (String num : numbers) {
            if (!num.trim().isEmpty()) {
                try {
                    int value = Integer.parseInt(num.trim());
                    // 음수가 있을 경우 예외 발생
                    if (value < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
                    }
                } catch (NumberFormatException e) {
                    // 숫자로 변환할 수 없는 경우의 예외 처리
                    throw new IllegalArgumentException("잘못된 숫자 형식이 포함되었습니다: " + num);
                }
            }
        }
    }
}
