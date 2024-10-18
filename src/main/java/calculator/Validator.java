package calculator;

public class Validator {
    private static final String ERROR_INVALID_DELIMITER = "커스텀 구분자로 숫자 또는 공백을 사용할 수 없습니다.";
    private static final String ERROR_INVALID_FORMAT = "커스텀 구분자 형식이 올바르지 않습니다.";
    private static final String INVALID_CUSTOM_DELIMITER_PATTERN = "//[\\d\\s]*((\\\\n)|(\\n)).*";

    private final String defaultDelimiter;
    private final String prefix;
    private final String suffix;

    public Validator(String defaultDelimiter, String prefix, String suffix) {
        this.defaultDelimiter = defaultDelimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public void validateDelimiter(String value){
        validateCustomDelimiterFormat(value);
    }

    private void validateCustomDelimiterFormat(String value){
        if(Character.isDigit(value.charAt(0))){
            return;
        }
        if (!value.startsWith(prefix) || !value.contains(suffix)) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
        if (value.matches(INVALID_CUSTOM_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER);
        }
    }
}
