package calculator;

import java.util.regex.Pattern;

public class InputValidation {
    public void validate(String input) {
        // 빈 문자열일 경우
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }

        // 패턴에 맞지 않는 경우
        if (!input.matches("^(//[^\\n]+\\n)?[\\d,;:]+$")) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }

}
