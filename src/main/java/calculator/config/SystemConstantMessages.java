package calculator.config;

public class SystemConstantMessages {
    public static final String UTILITY_CLASS_MESSAGE = "유틸리티 클래스 입니다.";
    public static final String VALIDATOR_CLASS_MESSAGE = "유효성 검증 클래스입니다.";
    public static final String VIEW_CLASS_MESSAGE = "인터페이스 클래스입니다.";
    public static final String CONFIG_CLASS_MESSAGE = "환경 설정 클래스입니다.";
    private SystemConstantMessages() {
        throw new IllegalStateException(CONFIG_CLASS_MESSAGE);
    }
}
