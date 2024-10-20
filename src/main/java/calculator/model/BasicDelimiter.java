package calculator.model;

public class BasicDelimiter {
    
    public static final String BASIC_DELIMITER_COMMA = ",";
    public static final String BASIC_DELIMITER_COLON = ":";

    private final String value;

    public BasicDelimiter(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
