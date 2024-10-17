package calculator;

public class ExceptionHandler {
    private final String userInput;
    private static final String CUSTOM_PATTERN = "^//(.+)\\\\n(.*)$";  // 커스텀 구분자 패턴
    private static final String COMMON_PATTERN = "^[0-9]+([,:][0-9]+)*$";  // 쉼표와 콜론 사용

    public ExceptionHandler(String userInput) {
        this.userInput = userInput;
    }

    // 입력 형식 검증 메서드
    public boolean validateInput() {
        if (userInput.isEmpty()) {
            return false;  // 빈 문자열은 정상 처리(결과 0 출력)
        }

        if (isCustomInput() || isCommonInput()) {
            return true;  // 유효한 입력일 경우 진행
        }

        throw new IllegalArgumentException("잘못된 입력 형식입니다.");  // 잘못된 입력 예외 처리
    }

    // 커스텀 구분자 형식 검증
    private boolean isCustomInput() {
        return userInput.matches(CUSTOM_PATTERN);
    }

    // 기본 구분자 형식 검증
    private boolean isCommonInput() {
        return userInput.matches(COMMON_PATTERN);
    }
}
