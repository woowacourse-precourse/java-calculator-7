package calculator.util;

public enum Exceptions {
    WRONG_DELIMITER("잘못된 구분자입니다. ',', ':' 또는 커스텀 구분자를 사용해주세요."),
    WRONG_NUMBER("잘못된 숫자입니다. 양수를 입력해주세요."),
    CUSTOM_DELI_NOT_ENDS("잘못된 커스텀 구분자입니다. '\\n'을 입력해 커스텀 구분자 입력을 마쳐주세요."),
    WRONG_CUSTOM_DELIMITER("잘못된 커스텀 구분자입니다. '//', '\\n', '-', ',', ':'와 숫자를 제외한 문자를 입력해주세요."),
    EXCEED_MAX_NUMBER_LENGTH("잘못된 숫자입니다. 10자리 이하로 입력해주세요."),
    ;

    private final String msg;

    Exceptions(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
