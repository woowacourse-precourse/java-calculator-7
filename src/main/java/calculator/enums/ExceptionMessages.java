package calculator.enums;

public enum ExceptionMessages {
    INCORRECT_INPUT_MSG("에러: 지정된 구분자인 쉼표와 콜론, 양의 정수, 커스텀 구분자를 지정하기 위한 슬래시와 역슬래시 그리고 n 이외에는 입력하실 수 없습니다."),
    INCORRECT_CUSTOM_DELIM_MSG("에러: 기본 구분자는 커스텀 구분자로 설정할 수 없습니다."),
    ZERO_AND_NEGATIVE_MSG("에러: 0 또는 음수는 입력할 수 없습니다! 양수만 입력해주세요.");

    private final String msg;

    ExceptionMessages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
