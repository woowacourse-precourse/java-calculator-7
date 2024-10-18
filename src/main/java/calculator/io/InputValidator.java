package calculator.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 사용자 입력값을 검증하는 역할
 */
public class InputValidator {
    private static final Pattern VALID_PATTERN = Pattern.compile("^(//.+\\\\n)?\\d+(.\\d+)*");

    /**
     * 입력값을 읽어 검증하고, 문제가 있다면 예외를 발생시킨다.
     *
     * @param input 사용자 입력값
     */
    public void validate(String input) {
        Matcher matcher = VALID_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}