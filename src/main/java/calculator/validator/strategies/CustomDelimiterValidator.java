package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.regex.Matcher;

// 커스텀 구분자를 검증하는 클래스
public class CustomDelimiterValidator implements ValidationStrategy {

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

        // 커스텀 구분자를 찾지 못하면 잘못된 형식으로 처리
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
        }

        return matcher;
    }

    // 추출한 구분자를 검증하는 메서드
    private void validateDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);

        // 구분자가 유효하지 않은지 검사하고 예외 던짐
        if (isInvalidDelimiter(customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
        }

        // 구분자가 없거나 비어있는 경우에도 예외 던짐
        if (isMissingDelimiter(customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage());
        }
    }

    // 구분자가 없거나 비어있는지 검사하는 메서드
    private boolean isMissingDelimiter(String delimiter) {
        return delimiter == null || delimiter.trim().isEmpty();  // 빈 구분자 처리
    }

    // 구분자가 유효하지 않은지 검사하는 메서드 (예: 역슬래시 같은 잘못된 구분자)
    private boolean isInvalidDelimiter(String delimiter) {
        return delimiter.equals("\\");  // 역슬래시가 잘못된 구분자일 때 처리
    }

}