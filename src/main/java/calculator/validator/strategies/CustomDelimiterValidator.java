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
        if (!matcher.matches() || isMissingNumbers(matcher.group(2))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
        }
    }

    // 입력 문자열이 커스텀 구분자로 시작하는지 확인
    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 숫자가 없는지 확인
    private boolean isMissingNumbers(String numberPart) {
        return numberPart.trim().isEmpty(); // 숫자 부분이 빈 문자열인 경우
    }

}