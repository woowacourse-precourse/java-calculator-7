package calculator;

import java.util.regex.Pattern;

/**
 * Input 클래스는 사용자가 입력한 문자열을 감싸는 도메인 객체로,
 * 문자열이 비어있는지 확인하는 기능을 제공합니다.
 */
public record Input(String input) {
    // 커스텀 구분자를 포함한 빈 문자열을 나타내는 정규 표현식
    private static final String EMPTY_INPUT_WITH_CUSTOM_DELIMITER = "^//.\\\\n$";

    /**
     * 입력된 문자열이 빈 문자열이거나 커스텀 구분자가 포함된 빈 입력인 경우 true를 반환합니다.
     *
     * @return 입력 문자열이 빈 경우 true, 그렇지 않으면 false
     */
    public boolean isEmpty() {
        return input.isEmpty() || Pattern.matches(EMPTY_INPUT_WITH_CUSTOM_DELIMITER, input);
    }
}
