package calculator.separator;

public enum DefaultSeparator {
    COMMA(","),
    COLON(":");
    private final String separator;
    DefaultSeparator(String separator) {
        this.separator =  separator;
    }

}
