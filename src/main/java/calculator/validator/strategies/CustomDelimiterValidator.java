package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.regex.Matcher;

// 커스텀 구분자를 검증하는 클래스
public class CustomDelimiterValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        if (isCustomDelimiter(input)) {
            validateCustomDelimiter(input);
        }
    }

    private void validateCustomDelimiter(String input) {
        Matcher matcher = DelimiterUtils.getCustomDelimiterPattern().matcher(input);

        // 구분자 패턴이 잘못되었거나 구분자가 없으면 예외 발생
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
        }

        // 구분자를 올바르게 추출하여 처리
        String customDelimiter = matcher.group(1);

        // 커스텀 구분자가 비어있거나 이스케이프된 구분자일 경우 예외 처리
        if (customDelimiter == null || customDelimiter.trim().isEmpty() || customDelimiter.equals("\\")) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_DELIMITER_ERROR.getMessage());
        }
    }

    // 입력 문자열이 커스텀 구분자로 시작하는지 확인하는 메서드
    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

}