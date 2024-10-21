package calculator.Message;

public enum IOMessage {
    INPUT_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_MESSAGE("결과 : ");

    private final String message; // final로 설정해야 함

    // enum 생성자
    IOMessage(String message) {
        this.message = message;
    }

    // 메시지를 반환하는 getter 메서드
    public String getMessage() {
        return message;
    }
}
