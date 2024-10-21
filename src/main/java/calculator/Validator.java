package calculator;

import java.util.regex.Pattern;

public class Validator {
    // 기본 구분자인 쉼표, 콜론을 기준으로 문자열 검증
    public void validateDefaultDelimiters(String input) {
        // 빈 문자열인 경우 바로 통과
        if (input.isEmpty()) {
            return;
        }

        // 쉼표(,)와 콜론(:)만 있는지 확인 (숫자, 쉼표, 콜론만 허용)
        if (input.matches("[0-9,:]+")) {
            System.out.println("입력값이 올바른 형식입니다.");
        }
    }

    // 커스텀 구분자를 이용한 문자열을 검증하는 메서드
    public void validateCustomDelimiters(String input) {
        // "//[구분자]\n[숫자들]" 형식인지 확인
        String delimiter = input.substring(2, input.indexOf("\n"));
        String numbersPart = input.substring(input.indexOf("\n") + 1);

        // 커스텀 구분자와 숫자로만 구성되어 있는지 검증
        if (numbersPart.matches("[0-9" + Pattern.quote(delimiter) + "]+")) {
            System.out.println("커스텀 구분자를 사용한 입력값이 올바른 형식입니다.");
        }
    }
}
