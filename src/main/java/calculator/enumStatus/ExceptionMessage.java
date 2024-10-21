package calculator.enumStatus;

public enum ExceptionMessage {
    INVALID_INPUT_ZERO {
        @Override
        public String toString() {
            return "사용자 입력의 숫자는 0보다 커야 합니다.";
        }
    },

    INVALID_NUM_RANGE {
        @Override
        public String toString() {
            return "32비트 내에서 입력할 수 있는 숫자의 최대 범위를 벗어났습니다.";
        }
    },

    INVALID_INPUT_CHAR {
        @Override
        public String toString() {
            return "사용자 입력은 기본 및 커스텀 구분자 및 숫자를 제외한 문자를 포함할 수 없습니다.";

        }
    },

    INVALID_CUSTOM_DELIMITER_CHAR {
        @Override
        public String toString() {
            return "커스텀 구분자 내에는 1개의 문자가 존재해야 합니다.";
        }
    };
}
