package calculator.enumStatus;

public enum ExceptionMessage {
    INVALID_INPUT_ZERO {
        @Override
        public String toString() {
            return "사용자 입력의 숫자는 0보다 커야 합니다.";
        }
    };
}
