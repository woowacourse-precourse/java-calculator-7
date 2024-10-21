package calculator.constant;

public final class Constants {

    private Constants() {
    }

    public static final class Separator {
        private Separator() {
        }

        public static final String DEFAULT_SEPARATOR_COMMA = ",";
        public static final String DEFAULT_SEPARATOR_COLON = ":";
        public static final String OR = "|";

        public static final String CUSTOM_SEPARATOR_PREFIX = "//";
        public static final String CUSTOM_SEPARATOR_SUFFIX = "\\\\n";

        public static final int CUSTOM_SEPARATOR_LENGTH = 1;

    }

    public static final class ErrorMessage {
        private ErrorMessage() {
        }

        public static final String EMPTY_SEPARATOR_ERROR = "커스텀 구분자가 비어있습니다.";
        public static final String INVALID_SEPARATOR_LENGTH_ERROR = "커스텀 구분자는 문자만 가능합니다.";
        public static final String DUPLICATE_SEPARATOR_ERROR = "기존 구분자와 중복됩니다.";
        public static final String NUMBER_RANGE_ERROR = "음수는 입력할 수 없습니다.";
        public static final String NUMBER_FORMAT_ERROR = "숫자 형식이 아닙니다";


    }

    public static final class TargetNumber {
        private TargetNumber() {
        }

        public static final int EMPTY_NUMBER = 0;
        public static final int NUMBER_MINIMUM_RANGE = 1;

    }

    public static final class Regex {
        private Regex() {
        }

        private static final String NON_NUMERIC_SINGLE_CHAR = "([^0-9])";
        private static final String ANY_TEXT = "(.*)";
        private static final String OPTIONAL = "?";

        public static final String CUSTOM_SEPARATOR_FORMAT_REGEX =
                Separator.CUSTOM_SEPARATOR_PREFIX
                        + NON_NUMERIC_SINGLE_CHAR
                        + Separator.CUSTOM_SEPARATOR_SUFFIX
                        + ANY_TEXT
                        + OPTIONAL;
    }

}
