package calculator.separator.domain;

public enum DefaultSeparator {
    DEFAULT_SEPARATOR(",|:");
    private final String separator;
    DefaultSeparator(String separator) {
        this.separator =  separator;
    }
    public static String getDefaultSeparator() {
        return DEFAULT_SEPARATOR.separator;
    }

}
