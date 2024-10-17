package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.regex.Matcher;

// 커스텀 구분자를 검증하는 클래스
public class CustomDelimiterValidator implements ValidationStrategy {

    private static final String INVALID_ESCAPE_CHARACTER = "\\";

    @Override
    public void validate(String input) {
        if (hasCustomDelimiter(input)) {
            Matcher matcher = extractCustomDelimiter(input);
            validateDelimiter(matcher);
        }
    }

    // 입력 문자열이 커스텀 구분자(//)로 시작하는지 확인하는 메서드
    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 커스텀 구분자를 추출하는 메서드
    private Matcher extractCustomDelimiter(String input) {
        Matcher matcher = DelimiterUtils.getCustomDelimiterPattern().matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
        }

        return matcher;
    }

    // 추출한 구분자를 검증하는 메서드
    private void validateDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);

        if (isInvalidDelimiter(customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_DELIMITER_ERROR.getMessage());
        }
    }

    // 구분자가 유효하지 않은지 검사하는 메서드
    private boolean isInvalidDelimiter(String delimiter) {
        return delimiter == null || delimiter.trim().isEmpty() || delimiter.equals(INVALID_ESCAPE_CHARACTER);
    }

}