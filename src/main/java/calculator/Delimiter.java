package calculator;

public enum Delimiter {
    REST(","),
    COLON(":"),
    CUSTOM_DELIMITER_START_POINT("//"),
    CUSTOM_DELIMITER_END_POINT("\n")
    ;

    private static final String SEPARATOR = "|";

    private final String symbol;

    Delimiter(String symbol) {
        this.symbol = symbol;
    }

    public static String getRegularDelimiter(){
        return REST.symbol + SEPARATOR + COLON.symbol;
    }
}
