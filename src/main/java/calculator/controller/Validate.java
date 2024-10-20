package calculator.controller;

import java.util.regex.Pattern;

/**
 * 입력값을 검증하는 Validate 클래스
 */
public class Validate {
    /**
     * 생성자를 private으로 선언하여 외부에서 인스턴스를 생성하지 못하도록 합니다.
     */
    private Validate() {
    }

    /**
     * 입력받는 문자열 검증(입력 요구 사항에 맞는 지 확인) 반환값이 0이면 오류 반환값이 1이면 문자열이 비어있지 않고, 입력 요구 사항에 맞음 반환값이 2이면 문자열이 비어있음
     */
    public static int isValidForm(String input, Pattern pattern) {
        if (pattern.matcher(input).matches()) {
            return 1;
        } else if (input.isEmpty()) {
            return 2;
        }
        return 0;
    }
}
