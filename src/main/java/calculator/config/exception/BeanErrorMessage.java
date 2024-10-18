package calculator.config.exception;

public enum BeanErrorMessage {
    BEAN_CREATION_ERROR("빈 생성 중 오류가 발생하였습니다 : "),
    CIRCULAR_REFERENCE_DETECTED("순환 참조가 감지되었습니다."),
    INVALID_BEAN_ERROR("해당 클래스는 빈이 아닙니다."),
    BEAN_NOT_FOUND("해당 클래스의 빈이 존재하지 않습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    BeanErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
