package calculator.validation;

import calculator.exception.CalculatorException;

import java.util.regex.Pattern;

public class DelimiterValidation {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\\\n(.*)$");
    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[0-9,:\n]+");

    // 입력값을 커스텀 구분자 형식인지 검사
    public boolean isCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
    }

    // 기본 구분자 형식인지 검사
    public boolean isDefaultDelimiter(String input) {
        return DEFAULT_DELIMITER_PATTERN.matcher(input).matches();
    }

    // 입력값이 유효한 형식인지 검사
    public void validate(String input) {
        if (!isCustomDelimiter(input) && !isDefaultDelimiter(input)) {
            throw new CalculatorException("잘못된 입력 형식입니다.");
        }
    }

    // 커스텀 구분자 패턴을 반환하는 메서드
    public static Pattern getCustomDelimiterPattern() {
        return CUSTOM_DELIMITER_PATTERN;
    }
}

