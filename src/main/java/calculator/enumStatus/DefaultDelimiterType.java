package calculator.enumStatus;

public enum DefaultDelimiterType {
    COMMA_DELIMITER {
        @Override
        public String toString() {
            return ",";
        }
    },
    COLON_DELIMITER {
        @Override
        public String toString() {
            return ":";
        }
    };
}
