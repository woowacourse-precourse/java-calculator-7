package calculator;

public class Validator {
    private static final String ERROR_INVALID_FORMAT = "커스텀 구분자 형식이 올바르지 않습니다.";

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
    }
}
