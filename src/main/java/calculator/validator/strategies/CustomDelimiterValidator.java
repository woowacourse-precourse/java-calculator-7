package calculator.validator.strategies;

import calculator.view.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 입력값이 커스텀 구분자를 사용할 경우, 그 구분자가 올바르게 정의되었는지 검증하는 클래스
public class CustomDelimiterValidator implements ValidationStrategy {

    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)$";

    @Override
    public void validate(String input) {
        if (isCustomDelimiter(input)) {
            Matcher matcher = parseCustomDelimiter(input);
            if (!matcher.matches() || isMissingNumbers(matcher.group(2))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
            }
        }
    }

    // 커스텀 구분자가 있는지 확인
    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 커스텀 구분자와 숫자 부분을 매칭하여 반환
    private Matcher parseCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        return pattern.matcher(input);
    }

    // 숫자가 없는지 확인
    private boolean isMissingNumbers(String numberPart) {
        return numberPart.trim().isEmpty();
    }

}