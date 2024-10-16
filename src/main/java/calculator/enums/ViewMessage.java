package calculator.enums;

import java.text.MessageFormat;

public enum ViewMessage {
    // Input
    PROMPT_STRING("덧셈할 문자열을 입력해 주세요."),
    PROMPT_HINT("문자열은 `,`과 `:`으로 구분됩니다. 추가적으로 문자열 앞에 `//`와 `\\n` 사이에 위치한 문자를 커스텀 구분자로 사용할 수 있습니다."),

    // Output
    START_CALCULATOR("문자열 덧셈 계산기를 시작합니다."),
    END_CALCULATOR("문자열 덧셈 계산기를 종료합니다."),
    RESULT("결과 : {0}");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}
