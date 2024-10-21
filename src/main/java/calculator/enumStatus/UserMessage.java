package calculator.enumStatus;

public enum UserMessage {
    START_MESSAGE {
        @Override
        public String toString() {
            return "덧셈할 문자열을 입력해 주세요.";
        }
    },

    END_MESSAGE {
        @Override
        public String toString() {
            return "결과 : ";
        }
    };
}
