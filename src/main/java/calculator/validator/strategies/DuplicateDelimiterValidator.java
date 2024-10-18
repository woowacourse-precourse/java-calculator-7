package calculator.validator.strategies;

import calculator.view.ErrorMessage;
import java.util.regex.Pattern;

// 연속된 구분자 검증
public class DuplicateDelimiterValidator implements ValidationStrategy {

    // 쉼표(,) 또는 콜론(:)이 연속해서 나타나는지 확인하는 패턴
    private static final Pattern CONSECUTIVE_DELIMITER_PATTERN = Pattern.compile("([,:])\\1");

    @Override
    public void validate(String input) {
        // 입력 문자열에서 연속된 구분자를 확인
        if (hasConsecutiveDelimiters(input)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DELIMITER_ERROR.getMessage());
        }
    }

    // 연속된 구분자(;;, ::)가 있는지 확인
    private boolean hasConsecutiveDelimiters(String input) {
        return CONSECUTIVE_DELIMITER_PATTERN.matcher(input).find();
    }

}