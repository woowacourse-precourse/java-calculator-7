package calculator.model.delimiter;

public enum StandardDelimiterType {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    StandardDelimiterType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter(){
        return delimiter;
    }
}
