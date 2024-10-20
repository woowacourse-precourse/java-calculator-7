package calculator.controller;

import java.util.regex.Pattern;

/**
 * 입력값을 검증하는 Validate 클래스. 단, 공백인 경우에는 false을 반환합니다.
 */
public class Validate {
    /**
     * 생성자를 private으로 선언하여 외부에서 인스턴스를 생성하지 못하도록 합니다.
     */
    private Validate() {
    }

    private static final Pattern PATTERN = Pattern.compile("(//.\\\\n)?\\d+(.\\d+)*$");

    /**
     * 입력받는 문자열 검증(숫자와 기본 구분자로 이루어져 있는지 확인)
     */
    public static boolean isValidForm(String input) {
        return PATTERN.matcher(input).matches();
    }
}
