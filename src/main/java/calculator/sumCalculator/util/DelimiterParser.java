package calculator.sumCalculator.util;

import calculator.common.exception.ExceptionCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String REGEXP_CUSTOM_DELIMITER_PATTERN = "//([^\s]+)\\n";
    private static final String INVALID_REGEXP_CUSTOM_DELIMITER_PATTERN = "//.*[\\s]+.*\\n";

    /**
     * 커스텀 구분자를 추출한다.
     * @param input 사용자 입력 문자열
     * @return 추출된 커스텀 구분자
     */
    public String extractCustomDelimiter(String input) {
        validate(input);
        Pattern pattern = Pattern.compile(REGEXP_CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    /**
     * 커스텀 구분자 유효성 검사한다.
     * 예외 패턴(공백) 사용 시 예외 처리한다.
     * @param input 사용자 입력 문자열
     */
    private void validate(String input) {
        Pattern invalidPattern = Pattern.compile(INVALID_REGEXP_CUSTOM_DELIMITER_PATTERN);
        Matcher invalidMatcher = invalidPattern.matcher(input);
        if (invalidMatcher.find()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CUSTOM_DELIMITER_PATTERN.getMessage());
        }
    }

    /**
     * 연산식에서 커스텀 구분자 유효성 검사한다.
     * 선언되지 않은 커스텀 구분자 사용 시, 예외 처리한다.
     * @param delimiter 커스텀 구분자
     */
    public void checkCustomDelimiterInExpression(String expression, String delimiter) {
        String invalidCheckRegex = "[^\\d" + Pattern.quote(delimiter) + "]";
        Pattern invalidCheckPattern = Pattern.compile(invalidCheckRegex);
        Matcher invalidMatcher = invalidCheckPattern.matcher(expression);
        if (invalidMatcher.find()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CUSTOM_DELIMITER_USED.getMessage());
        }
    }
}
