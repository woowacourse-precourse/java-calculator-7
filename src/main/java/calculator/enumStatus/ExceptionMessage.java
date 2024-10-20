package calculator.enumStatus;

public enum ExceptionMessage {
    INVALID_INPUT_ZERO {
        @Override
        public String toString() {
            return "사용자 입력의 숫자는 0보다 커야 합니다.";
        }
    },

    INVALID_INPUT_CHAR {
        @Override
        public String toString() {
            return "사용자 입력은 기본 및 커스텀 구분자 및 숫자를 제외한 문자를 포함할 수 없습니다.";

        }
    };
}
