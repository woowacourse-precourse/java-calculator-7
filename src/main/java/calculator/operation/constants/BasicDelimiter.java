package calculator.operation.constants;

public enum BasicDelimiter {

    COMMA(","),
    COLON(":"),
    ;

    private final String delimiter;

    public String getDelimiter() {
        return delimiter;
    }

    private BasicDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

}
